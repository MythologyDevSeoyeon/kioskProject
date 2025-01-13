package com.example.Level1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[ SHAKESHACK MENU ]");
        System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        System.out.println("3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        System.out.println("4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");

        while (true) {
            try {
                System.out.print("주문하실 ShackBurger Menu 번호를 입력하세요 (0 입력 시 종료): ");
                int menuNumber = sc.nextInt();
                sc.nextLine();

                switch (menuNumber) {
                    case 1:
                        System.out.println("1번 메뉴 ShackBurger를 주문하였습니다.");
                        break;
                    case 2:
                        System.out.println("2번 메뉴 SmokeShack를 주문하였습니다.");
                        break;
                    case 3:
                        System.out.println("3번 메뉴 Cheeseburger를 주문하였습니다.");
                        break;
                    case 4:
                        System.out.println("4번 메뉴 Hamburger를 주문하였습니다.");
                        break;
                    case 0:
                        System.out.println("프로그램을 종료합니다.");
                        System.exit(0);
                    default:
                        System.out.println("없는 메뉴입니다. 다시 입력해 주세요");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("유효하지 않은 입력입니다.");
                sc.next();
            }
        }
    }
}
