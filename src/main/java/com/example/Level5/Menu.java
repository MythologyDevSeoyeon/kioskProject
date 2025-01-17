package com.example.Level5;
import java.util.Collections;
import java.util.List;

public class Menu {
    //필드
    private final List<MenuItem> menuItems;
    private final String category;

    //생성자
    public Menu(String category, List<MenuItem>menuItems){
        this.category = category;
        // 생성자에서 전달 받은 리스트의 복사본을 내부 리스트에 할당
        this.menuItems = menuItems;
    }

    // 메뉴 아이템 리스트 반환 getter
    //Collections.unmodifiableList을 이용하여 읽기 전용으로 반환
    public List<MenuItem> getMenuItems(){
        return Collections.unmodifiableList(menuItems);
    }

    //카테고리 반환 getter
    public String getCategory(){
        return category;
    }

}