package com.example.Level4;

import java.util.List;

public class Menu {

    //필드 : 메뉴 아이템들의 리스트 + 카테고리
    List<MenuItem> menuItems;
    String category;

    // 생성자
    Menu(String category, List<MenuItem> menuItems){
        this.category = category;
        this.menuItems = menuItems;
    }

    //메뉴 아이템들의 리스트를 출력하는 메소드
    public void displayMenuItem(){
        System.out.println("[" + category + "]");
        for(int i = 0; i < menuItems.size(); i++){
            MenuItem item = menuItems.get(i); // menuItem 가져오기
            System.out.printf("%d. %-15s | W %-4.1f | %s\n",
                    (i + 1), item.name, item.price, item.description);
        }
        System.out.println("0. 뒤로가기");
    }
}
