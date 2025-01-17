package com.example.Level3;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //필드
    List<MenuItem> menuItems;

    //생성자
    Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    //프로그램 시작 메소드
    public void start() {

        //반복문을 이용하여 메뉴 출력
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            System.out.println((i + 1) + ". " + item.name + " | W " + item.price + " | " + item.description);
        }

        Scanner sc = new Scanner(System.in);

        //입력된 숫자에 따른 주문 문구 출력
        while (true) {
            try {
                System.out.print("주문하실 Menu 번호를 입력하세요 (0 입력 시 종료): ");
                int menuNumber = sc.nextInt();
                sc.nextLine();

                if (menuNumber == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else {
                    MenuItem item = menuItems.get(menuNumber - 1);
                    System.out.println(menuNumber + "번 메뉴를 선택하였습니다. " +
                            "\n이름 : " + item.name + ", 가격 : " + item.price + ", 설명 : " + item.description);
                }

            } catch (InputMismatchException e) {
                System.out.println("유효하지 않은 입력입니다.");
                sc.nextLine();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("없는 메뉴 입니다. 1부터 " + menuItems.size() + "까지 번호로 다시 입력해 주세요.");
            }
        }
    }


}
