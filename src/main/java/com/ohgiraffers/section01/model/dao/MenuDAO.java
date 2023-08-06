package com.ohgiraffers.section01.model.dao;

import com.ohgiraffers.common.JDBCTemplate;
import com.ohgiraffers.section01.model.dto.CategoryDTO;
import com.ohgiraffers.section01.model.dto.MenuDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class MenuDAO {

    private Properties prop = new Properties();     // * 순서.10

    public MenuDAO(){
        try {   // * 순서.11
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/category-query.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* 신규 카테고리 등록용 메소드 */
    // 카테고리 테이블에 인서트하기 위한 목적으로 만든 메소드
    public int insertNewCategory(Connection con, CategoryDTO newCategory) {

        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("insertCategory");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, newCategory.getName());
            pstmt.setObject(2, newCategory.getRefCategoryCode());

            result = pstmt.executeUpdate(); // 실행

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }



    public int selectLastCategoryCode(Connection con) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = prop.getProperty("getCurrentSequence");

        int newCategoryCode = 0;


        try {
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();

            if(rset.next()) {
                newCategoryCode=  rset.getInt("CURRVAL");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return newCategoryCode; // * 순서.19
    }



    /* 신규 메뉴 등록용 메소드 */
    public int insertNewMenu(Connection con, MenuDTO newMenu) {
        // * 순서.24-2
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("insertMenu");
        // * 순서.24-3
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, newMenu.getName());
            pstmt.setInt(2, newMenu.getPrice());
            pstmt.setObject(3, newMenu.getCategoryCodeList().getCode());
            pstmt.setString(4, newMenu.getOrderableStatus());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt); // * 순서. 24-5
        }

        return result; // * 순서. 24-4
    }
}
