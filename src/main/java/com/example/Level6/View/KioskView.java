package com.example.Level6.View;

import com.example.Level6.Model.Cart;
import com.example.Level6.Model.Menu;
import com.example.Level6.Model.MenuItem;
import com.example.Level6.Model.UserType;

import java.util.List;

public class KioskView {

    // Main 메뉴 출력
    public static void displayMainMenu(List<Menu> menus, boolean checkCartItem) {
        System.out.println("[ Main Menu ]");
        for (int i = 0; i < menus.size(); i++) {
            Menu menu = menus.get(i);
            System.out.printf("%d. %-15s\n", (i + 1), menu.getCategory());  // 출력 문구
        }
        if (checkCartItem) {
            System.out.println(" [ Order Menu ]");
            System.out.printf("%-15s | 장바구니를 확인 후 주문합니다.\n", "4. Orders");
            System.out.printf("%-15s | 진행중인 주문을 취소합니다.\n", "5. Cancel");
        }
        System.out.println("0. 종료하기");
    }

    // Sub 메뉴 출력
    public static void displaySubMenu(Menu menu) {
        System.out.println("[" + menu.getCategory() + "]");
        for (int i = 0; i < menu.getMenuItems().size(); i++) {
            MenuItem item = menu.getMenuItems().get(i);
            System.out.printf("%d. %s \n",
                    (i + 1), item.converterFormatDisplay());
        }
        System.out.println("0. 뒤로가기");
    }

    //주문 목록 출력 -> sum을 사용하기 위해 return
    public static double displayOrderList(Cart cart) {
        System.out.println("[ Orders ]");
        double sum = 0;
        for (MenuItem item : cart.getOrderList()) {
            System.out.println(item.converterFormatDisplay());
            sum += item.getPrice();
        }
        System.out.println(" [ Total ] ");
        System.out.printf("W %.1f\n",sum);
        return sum;
    }

    //할인 정보 출력
    public static void displayDiscount() {
        UserType[] userTypes = UserType.values();
        for (int i = 0; i < UserType.values().length; i++) {
            System.out.printf("%d. %s: %d%%\n", i+1, userTypes[i].getName(), userTypes[i].getDiscountPercent());
        }
    }

}
