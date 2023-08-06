package com.ohgiraffers.section01.model.view;

import com.ohgiraffers.section01.model.dto.CategoryDTO;
import com.ohgiraffers.section01.model.dto.MenuDTO;
import com.ohgiraffers.section01.model.service.MenuService;
import java.util.List;
import java.util.Scanner;

public class MenuView {
    private MenuService menuService = new MenuService();

    public void displayMainMenu() {

        /*
         * 1. 카테고리 조회
         * 2. 신규 카테고리 넣기
         * 3. 신규 카테고리 잘 넣었는지 확인
         * 4. 신규 메뉴 넣기
         * 5. 신규 메뉴 잘 넣었는지 확인
         * */


        Scanner sc = new Scanner(System.in);
        MenuDTO menuDTO = new MenuDTO();
        CategoryDTO categoryDTO = new CategoryDTO();


        System.out.println("=========== 신규 카테고리 만들기===========");
        System.out.print("신규 카테고리 명을 입력 : ");
        String inputCategory = sc.nextLine();

        System.out.print("신규 카테고리 상위 코드를 입력 : ");
        int inputRefCategoryCode = sc.nextInt();
        sc.nextLine();

        categoryDTO.setName(inputCategory);
        categoryDTO.setRefCategoryCode(inputRefCategoryCode);

        /* ----------------------------------------------- */

        System.out.println("=========== 신규 메뉴 만들기 ============");
        System.out.print("신규 메뉴 명을 입력 : ");
        String inputMenuName = sc.nextLine();

        System.out.print("신규 메뉴 가격을 입력 : ");
        int inputMenuPrice = sc.nextInt();
        sc.nextLine();
        System.out.print("신규 메뉴 판매를 시작하시겠습니까? (Y/N) : ");
        String inputStatus = sc.nextLine();

        menuDTO.setName(inputMenuName);
        menuDTO.setPrice(inputMenuPrice);
        menuDTO.setOrderableStatus(inputStatus);

        menuDTO.setCategoryCodeList(categoryDTO);

        int result = menuService.registNewMenu(menuDTO);

        if(result > 0) {
            System.out.println("신규 카테고리와 메뉴 등록을 성공하였습니다.");
        } else {
            System.out.println("신규 카테고리와 메뉴 등록을 실패하였습니다.");
        }

    }
}









