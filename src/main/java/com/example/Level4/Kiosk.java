package com.example.Level4;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //필드 : 메뉴들의 리스트
    List<Menu> menus;

    //생성자
    Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    //키오스크 시작 메소드
    public void start() {
        while (true) {

            //상위 카테고리 메뉴 출력 및 선택
            displayMainMenu();

            //예외처리된 입력값
            int option = getUserInput("메뉴를 선택하세요 : ");

            //option 0 이면 프로그램 종료
            if (option == 0) {
                System.out.println("키오스크를 종료합니다.");
                break; // 프로그램 종료
            } else if (option < 1 || option > menus.size()) {    //없는 메뉴 입력 처리
                System.out.println("없는 메뉴 입니다. 다시 입력해 주세요.");
                continue;
            }

            //선택한 메뉴
            Menu menu = menus.get(option - 1);

            //메뉴 아이템 출력
            menu.displayMenuItem();

            //선택한 하위 메뉴 처리
            handleSubMenu(menu);
        }
    }

    //예외 처리된 입력값 메소드
    public int getUserInput(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        int option = -1;
        try {
            option = sc.nextInt();
            sc.nextLine(); // 입력 버퍼 정리
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요.");
            sc.nextLine(); // 잘못된 입력 버퍼 정리
        }
        return option;
    }

    //상위 메뉴를 출력하는 메소드
    public void displayMainMenu() {
        System.out.println("[ Main Menu ]");
        for (int i = 0; i < menus.size(); i++) {
            Menu menu = menus.get(i); // menu 가져오기
            System.out.printf("%d. %-15s\n", (i + 1), menu.category);
        }
        System.out.println("0. 종료하기");
    }

    //하위 메뉴를 처리하는 메소드
    public void handleSubMenu(Menu menu) {
        while (true) {

            //입력값 예외 처리
            int option = getUserInput("주문하실 항목을 선택하세요 : ");

            if (option == 0) {
                System.out.println("뒤로가기를 선택하였습니다.");
                break; // 상위 메뉴로 돌아가기
            } else if (option < 1 || option > menu.menuItems.size()) { // 유효하지 않은 메뉴
                System.out.println("없는 메뉴 입니다. 다시 입력해 주세요.");
            } else {
                //선택한 메뉴 아이템 출력
                MenuItem item = menu.menuItems.get(option - 1);
                System.out.printf("== %d번 메뉴를 선택 하였습니다.\n", option);
                System.out.printf("== %s | W %-4.1f | %s \n", item.name, item.price, item.description);
            }
        }
    }

}
