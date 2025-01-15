package com.example.Level5;

import java.util.*;

public class Kiosk {

    //필드
    private final List<Menu> menus;

    //생성자
    Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    //메뉴 리스트를 반환하는 getter
    public List<Menu> getMenus() {
        return Collections.unmodifiableList(menus);
    }

    //키오스크 시작 메소드
    public void start() {

        while (true) {
            //상위 카테고리 메뉴 출력 및 선택
            displayMainMenu();

            //입력값 받기
            int option = getUserInput("메뉴를 선택하세요 : ");

            //프로그램 종료
            if (option == 0) {
                System.out.println("키오스크를 종료합니다.");
                break;
            } else if (option < 1 || option > getMenus().size()) { //없는 메뉴
                System.out.println("없는 메뉴 입니다. 다시 입력해주세요.");
                continue;
            }

            //선택한 메뉴
            Menu menu = getMenus().get(option - 1);

            //메뉴 아이템 출력
            menu.displayMenuItem();

            //하위 메뉴 아이템 출력
            handleSubMenu(menu);

        }
    }

    //예외 처리된 입력값 메소드
    public int getUserInput(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        int option = -1;
        try {
            option = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("잘못된 값입니다. 숫자를 입력하세요.");
            sc.nextLine();
        }
        return option;
    }

    //상위 메뉴를 출력하는 메소드
    public void displayMainMenu() {
        System.out.println("[ Main Menu ]");
        for (int i = 0; i < getMenus().size(); i++) {
            Menu menu = getMenus().get(i);
            System.out.printf("%d. %-15s\n", (i + 1), menu.getCategory());
        }
        System.out.println("0. 종료하기");
    }

    //하위 메뉴를 반복 출력하는 메소드
    public void handleSubMenu(Menu menu) {
        while (true) {

            int option = getUserInput("주문하실 항목을 선택하세요 : ");

            //뒤로가기
            if (option == 0) {
                System.out.println("뒤로가기를 선택하였습니다.");
                break; // 상위 메뉴로 돌아가기
            } else if (option < 1 || option > menu.getMenuItems().size()) { // 유효하지 않은 메뉴
                System.out.println("없는 메뉴 입니다. 다시 입력해 주세요.");
            } else {
                //선택한 메뉴 아이템 출력
                MenuItem item = menu.getMenuItems().get(option - 1);
                System.out.printf("== %d번 메뉴를 선택 하였습니다.\n", option);
                System.out.printf("== %s | W %-4.1f | %s \n", item.getName(), item.getPrice(), item.getDescription());
            }
        }
    }
}
