package com.example.Level6;

import java.util.*;

public class Kiosk {

    //필드
    private final List<Menu> menus;
    private final Cart cart;

    //생성자
    Kiosk(List<Menu> menus) {
        this.menus = menus;
        this.cart = new Cart(new ArrayList<>());
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
            }

            int maxIndex = cart.checkItem() ? 5 : 3;
            if (option < 1 || option > maxIndex) { //없는 메뉴
                System.out.println("xx 없는 메뉴 입니다. 다시 입력해주세요. xx");
                continue;
            }

            if (option == 4) {
                if (cart.checkItem()) {
                    handleOrder(); // 주문 관련 메소드
                    continue;
                }
            }

            Menu menu = menus.get(option - 1); // 선택한 메뉴
            displaySubMenu(menu);  // 메뉴안의 아이템들을 출력
            MenuItem item = handleSubMenu(menu);  //하위 메뉴 아이템 선택
            handleCart(item); //장바구니 추가

        }
    }

    //상위 메뉴를 출력하는 메소드
    private void displayMainMenu() {
        System.out.println("[ Main Menu ]");
        for (int i = 0; i < getMenus().size(); i++) {
            Menu menu = getMenus().get(i);
            System.out.printf("%d. %-15s\n", (i + 1), menu.getCategory());  // 출력 문구
        }
        if (cart.checkItem()) {
            System.out.println(" [ Order Menu ]");
            System.out.printf("%-15s | 장바구니를 확인 후 주문합니다.\n", "4. Orders");
            System.out.printf("%-15s | 진행중인 주문을 취소합니다.\n", "5. Cancel");
        }
        System.out.println("0. 종료하기");
    }


    //예외 처리된 입력값 메소드
    private int getUserInput(String prompt) {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        while (true) {
            try {
                System.out.print(prompt); // 출력 문구
                option = sc.nextInt();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("잘못된 값입니다. 숫자를 입력하세요.");
                sc.nextLine();
            }
        }
        return option;
    }

    // 주문 메소드
    private void handleOrder() {
        System.out.println(" [ Orders ]");
        double sum = 0;
        for (MenuItem item : cart.getOrderList()) {
            System.out.println(item.converterFormatDisplay());
            sum += item.getPrice();
        }
        System.out.println(" [ Total ] ");
        System.out.println("W " + sum);

        System.out.println("주문 하시겠습니까?");

        int confirm = getUserInput(String.format("%-10s | %s\n", "1. 주문", "2. 메뉴판"));
        if (confirm == 1) {
            System.out.printf("주문이 완료되었습니다. 총 금액은 W %.1f입니다.\n", sum);
            cart.clearItem();
        } else if (confirm == 2) {
            System.out.println("메뉴판으로 이동하였습니다.");
        } else {
            System.out.println("잘못된 값을 입력하였습니다. 메뉴판으로 이동합니다.");
        }
    }


    // 장바구니 메소드
    private void handleCart(MenuItem item) {
        if (item == null) {
            return;
        }
        int option = getUserInput(String.format("위 메뉴를 장바구니에 추가하겠습니까?\n%-10s | %s \n", "1. 확인", "2. 취소"));
        if (option != 1 && option != 2) {
            System.out.println("잘못된 값을 입력하였습니다. 메뉴판으로 이동합니다.");
            return;
        }
        if (option == 1) {
            cart.addItem(item);
            System.out.println(item.getName() + "이(가) 추가되었습니다.");
        } else {
            System.out.println("장바구니 추가를 취소했습니다.");
        }
    }


    //서브 메뉴 리스트를 출력
    private void displaySubMenu(Menu menu) {
        System.out.println("[" + menu.getCategory() + "]");
        for (int i = 0; i < menu.getMenuItems().size(); i++) {
            MenuItem item = menu.getMenuItems().get(i);
            System.out.printf("%d. %s \n",
                    (i + 1), item.converterFormatDisplay());
        }
        System.out.println("0. 뒤로가기");
    }

    //서브 메뉴를 선택
    private MenuItem handleSubMenu(Menu menu) {
        while (true) {
            int option = getUserInput("주문하실 항목을 선택하세요 : "); // 입력값 받기 및 검증
            if (option == 0) { // 뒤로 가기
                System.out.println("뒤로가기를 선택하였습니다.");
                return null;
            }
            if (option < 1 || option > menu.getMenuItems().size()) { // 유효하지 않은 메뉴
                System.out.println("xx 없는 메뉴 입니다. 다시 입력해 주세요.xx");
                continue;
            }
            MenuItem item = menu.getMenuItems().get(option - 1); // 선택한 메뉴 아이템
            System.out.printf("== %d번 메뉴를 선택 하였습니다.\n", option); //메뉴 아이템 출력
            System.out.printf("== %s \n", item.converterFormatDisplay());
            return item;
        }
    }
}
