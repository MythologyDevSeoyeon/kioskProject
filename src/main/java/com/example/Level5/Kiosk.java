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
    private List<Menu> getMenus() {
        return Collections.unmodifiableList(menus);
    }

    //키오스크 시작 메소드
    public void start() {

        while (true) {

            displayMainMenu(); //상위 카테고리 메뉴 출력
            int option = getUserInput("메뉴를 선택하세요 : "); //입력값 받기 및 검증

            if (option == 0) { //프로그램 종료
                System.out.println("키오스크를 종료합니다.");
                break;
            } else if (option < 1 || option > getMenus().size()) { //없는 메뉴
                System.out.println("없는 메뉴 입니다. 다시 입력해주세요.");
                continue;
            }

            Menu menu = getMenus().get(option - 1); // 선택한 메뉴
            displaySubMenu(menu);  // 메뉴안의 아이템들을 출력
            handleSubMenu(menu);  //하위 메뉴 아이템 반복 로직

        }
    }

    //예외 처리된 입력값 메소드
    private int getUserInput(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt); // 출력 문구
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
    private void displayMainMenu() {
        System.out.println("[ Main Menu ]");
        for (int i = 0; i < getMenus().size(); i++) {
            Menu menu = getMenus().get(i);
            System.out.printf("%d. %-15s\n", (i + 1), menu.getCategory());  // 출력 문구
        }
        System.out.println("0. 종료하기");
    }


    //하위 메뉴를 출력하는 메소드
    private void displaySubMenu(Menu menu) {
        System.out.println("[" + menu.getCategory() + "]");
        for (int i = 0; i < menu.getMenuItems().size(); i++) {
            MenuItem item = menu.getMenuItems().get(i);
            System.out.printf("%d. %s \n",
                    (i + 1), item.parseDisplayItem());
        }
        System.out.println("0. 뒤로가기");
    }

    //하위 메뉴를 반복 출력하는 메소드
    private void handleSubMenu(Menu menu) {
        while (true) {
            int option = getUserInput("주문하실 항목을 선택하세요 : "); // 입력값 받기 및 검증

            if (option == 0) { // 뒤로 가기
                System.out.println("뒤로가기를 선택하였습니다.");
                break; // 상위 메뉴로 돌아가기
            } else if (option < 1 || option > menu.getMenuItems().size()) { // 유효하지 않은 메뉴
                System.out.println("없는 메뉴 입니다. 다시 입력해 주세요.");
            } else {
                MenuItem item = menu.getMenuItems().get(option - 1); // 선택한 메뉴 아이템
                System.out.printf("== %d번 메뉴를 선택 하였습니다.\n", option); //메뉴 아이템 출력
                System.out.printf("== %s \n", item.parseDisplayItem());
            }
        }
    }
}
