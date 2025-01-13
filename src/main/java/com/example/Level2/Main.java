package com.example.Level2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();

        MenuItem item1 = new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem item2 = new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem item3 = new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem item4 = new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        menuItems.add(item1);
        menuItems.add(item2);
        menuItems.add(item3);
        menuItems.add(item4);

        //반복문을 이용하여 메뉴 출력
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            System.out.println((i + 1) + ". " + item.name + " | W " + item.price + " | " + item.description);
        }

        Scanner sc = new Scanner(System.in);

        //입력된 숫자에 따른 주문 문구 출력
        while(true){
            try {
                System.out.print("주문하실 Menu 번호를 입력하세요 (0 입력 시 종료): ");
                int menuNumber = sc.nextInt();
                sc.nextLine();

                if(menuNumber == 0){
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else {
                    MenuItem item = menuItems.get(menuNumber - 1);
                    System.out.println(menuNumber +"번 메뉴를 선택하였습니다. " +
                            "\n이름 : " + item.name + ", 가격 : " + item.price + ", 설명 : " + item.description);
                }

            } catch (InputMismatchException e) {
                System.out.println("유효하지 않은 입력입니다.");
                sc.nextLine();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("없는 메뉴 입니다. 1부터 "+ menuItems.size() +"까지 번호로 다시 입력해 주세요.");
            }
        }

    }
}
