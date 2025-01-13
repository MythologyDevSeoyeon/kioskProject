package com.example.Level4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //필드 : 메뉴들의 리스트
    List<Menu> menus;

    //생성자
    Kiosk() {
        menus = new ArrayList<>(); // 초기화
    }

    //메뉴를 출력하는 메소드
    public void displayMenu() {
        System.out.println("[ Main Menu ]");
        for (int i = 0; i < menus.size(); i++) {
            Menu menu = menus.get(i); // menu 가져오기
            System.out.printf("%d. %-15s\n", (i + 1), menu.category);
        }
    }

    //키오스크 시작 메소드
    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            //상위 카테고리 메뉴 출력
            displayMenu();
            int option = -1;

            while (true) {
                try {
                    //입력 받은 숫자에 따른 하위 메뉴 출력하기
                    System.out.print("메뉴를 선택하세요 : ");
                    option = sc.nextInt();

                    //option에 0 입력시 종료
                    if (option == 0) {
                        System.out.println("키오스크를 종료합니다.");
                        return; // 프로그램 종료
                    } else if (option < 1 || option > menus.size()) {
                        System.out.println("없는 메뉴 입니다. 다시 입력해 주세요.");
                    } else {
                        break;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("유효하지 않은 입력입니다.");
                    sc.nextLine();
                }
            }

            //선택한 메뉴 가져오기
            Menu menu = menus.get(option - 1);
            menu.displayMenuItem();

            while (true) {
                try {
                    System.out.print("주문하실 항목을 선택하세요 : ");
                    int option2 = sc.nextInt();
                    sc.nextLine();

                    if (option2 == 0) {
                        System.out.println("뒤로가기를 선택하였습니다.");
                        break; // 상위 메뉴로 돌아가기
                    } else if (option2 < 1 || option2 > menu.menuItems.size()) {
                        System.out.println("없는 메뉴 입니다. 다시 입력해 주세요.");
                    } else {
                        MenuItem item = menu.menuItems.get(option2 - 1);
                        System.out.printf("== %d번 메뉴를 선택 하였습니다. \n== 이름 : %s | 가격 : %f | 설명 : %s \n", option2, item.name, item.price, item.description);
                    }

                } catch (InputMismatchException e) {
                    System.out.println("유효하지 않은 입력입니다.");
                    sc.nextLine();
                }
            }
        }
    }
}
