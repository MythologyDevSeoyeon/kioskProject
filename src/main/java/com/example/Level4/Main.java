package com.example.Level4;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<MenuItem> hamburgers = new ArrayList<>();
        //hamburger 메뉴의 MenuItem 리스트 생성 및 데이터 추가
        hamburgers.add(new MenuItem("ShackBurger", 6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        hamburgers.add(new MenuItem("SmokeShack", 8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        hamburgers.add(new MenuItem("Cheeseburger", 6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        hamburgers.add(new MenuItem("Hamburger", 5.4,"비프패티를 기반으로 야채가 들어간 기본버거"));

        List<MenuItem> drinks = new ArrayList<>();
        drinks.add(new MenuItem("Coke", 2.5, "탄산음료"));
        drinks.add(new MenuItem("Water", 0.9, "생수"));
        drinks.add(new MenuItem("MilkShake", 5.9, "밀크쉐이크"));
        drinks.add(new MenuItem("Lemonade", 3.9, "레몬에이드"));

        //메뉴 객체 생성
        Menu hamburgerMenu  = new Menu ("Hamburgers", hamburgers);
        Menu drinksMenu = new Menu("Drinks", drinks);


        //키오스크 실행
        kiosk.start();
    }
}
