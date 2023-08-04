package com.ohgiraffers.section01.model.dto;

import java.util.List;

public class MenuDTO {
    // * 순서.21 필드 선언, 생성자, getter/setter, toString 만들기

    private int code;
    private String name;
    private int price;
    private List<CategoryDTO> categoryCodeList;
    private String orderableStatus;

    public MenuDTO() {
    }

    public MenuDTO(int code, String name, int price, List<CategoryDTO> categoryCodeList, String orderableStatus) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.categoryCodeList = categoryCodeList;
        this.orderableStatus = orderableStatus;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<CategoryDTO> getCategoryCodeList() {
        return categoryCodeList;
    }

    public void setCategoryCodeList(List<CategoryDTO> categoryCodeList) {
        this.categoryCodeList = categoryCodeList;
    }
    

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categoryCodeList=" + categoryCodeList +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}


