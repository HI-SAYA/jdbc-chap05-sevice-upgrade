package com.ohgiraffers.section01.model.service;

import com.ohgiraffers.section01.model.dao.MenuDAO;
import com.ohgiraffers.section01.model.dto.MenuDTO;
import java.sql.Connection;
import static com.ohgiraffers.common.JDBCTemplate.*;

public class MenuService {

    public int registNewMenu(MenuDTO newMenu) {

        /* 신규 카테고리 등록 후 신규 카테고리 코드로 신규 메뉴를 등록하는 기능 */

        Connection con = getConnection();
        MenuDAO menuDAO = new MenuDAO();


        /*  CategoryDTO newCategory = new CategoryDTO(); */

        int result1 = menuDAO.insertNewCategory(con, newMenu.getCategoryCodeList());


        /* 방금 입력 된 카테고리의 코드 조회 */

        int newCategoryCode = menuDAO.selectLastCategoryCode(con);

        newMenu.getCategoryCodeList().setCode(newCategoryCode);

        /* ***************************************** */

        /* 메뉴 등록 */

        int result2 = menuDAO.insertNewMenu(con, newMenu);

        close(con);

        if (result1 > 0 && result2 > 0) {
            commit(con);
            return 1;
        } else {
            rollback(con);
            return 0;
        }


    }
}

