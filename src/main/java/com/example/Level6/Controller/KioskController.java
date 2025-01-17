package com.example.Level6.Controller;

import com.example.Level6.Model.Cart;
import com.example.Level6.Model.Menu;
import com.example.Level6.Model.MenuItem;
import com.example.Level6.View.KioskView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class KioskController {

    private final List<Menu> menus;
    private final Cart cart;

    public KioskController(List<Menu> menus) {
        this.menus = menus;
        this.cart = new Cart(new ArrayList<>());
    }

    //키오스크 시작 메소드 (서비스)
    public void start() {
        while (true) {
            KioskView.displayMainMenu(menus, cart.checkItem()); //상위 카테고리 메뉴 출력
            int option = getUserInput("메뉴를 선택하세요 : "); //입력값 받기 및 검증

            if (option == 0) { //프로그램 종료
                System.out.println("키오스크를 종료합니다.");
                break;
            }

            //장바구니 제품 유무로, option의 선택지 검증
            int maxIndex = cart.checkItem() ? 5 : 3;
            if (option < 1 || option > maxIndex) { //없는 메뉴
                System.out.println("xx 없는 메뉴 입니다. 다시 입력해주세요. xx");
                continue;
            }

            if (option == 4) {
                if (cart.checkItem()) {
                    KioskView.displayOrderList(cart);
                    handleOrder(); // 주문 관련 메소드
                    continue;
                }
            }

            if (option == 5) {
                System.out.println("진행 중인 주문을 취소하였습니다.");
                cart.clearItem();
                continue;
            }

            Menu menu = menus.get(option - 1); // 선택한 메뉴
            KioskView.displaySubMenu(menu);  // 메뉴안의 아이템들을 출력

            MenuItem item = handleSubMenu(menu);  //하위 메뉴 아이템 선택
            handleCart(item); //장바구니 추가

        }
    }

    // 장바구니 메소드
    private void handleCart(MenuItem item) {
        if (item == null) {
            return;
        }
        while (true) {
            int option = getUserInput(String.format("위 메뉴를 장바구니에 추가하겠습니까?\n%-10s | %s \n", "1. 확인", "2. 취소"));
            if (option != 1 && option != 2) {
                System.out.println("잘못된 값을 입력하였습니다.");
                continue;
            }
            if (option == 1) {
                cart.addItem(item);
                System.out.println(item.getName() + "이(가) 추가되었습니다.");
            } else {
                System.out.println("장바구니 추가를 취소했습니다.");
            }
            break;
        }
    }

    // 주문 메소드
    private void handleOrder() {
        while (true) {
            int confirm = getUserInput(String.format("%-10s | %s\n", "1. 주문", "2. 메뉴판"));
            if (confirm == 1) {
                double sum = KioskView.displayOrderList(cart);
                System.out.printf("주문이 완료되었습니다. 총 금액은 W %.1f입니다.\n", sum);
                cart.clearItem();
                break;
            } else if (confirm == 2) {
                System.out.println("메뉴판으로 이동하였습니다.");
                break;
            } else {
                System.out.println("잘못된 값을 입력하였습니다.");
            }
        }
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

    //예외 처리된 입력값 메소드
    private int getUserInput(String prompt) {
        Scanner sc = new Scanner(System.in);
        int option;
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

}
