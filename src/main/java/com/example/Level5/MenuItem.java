package com.example.Level5;

public class MenuItem {
    //필드
    private final String name;
    private final double price;
    private final String description;

    //생성자
    MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    //아이템 parse (getter 대신)
    public String parseDisplayItem(){
        return String.format("%-15s | W %-4.1f | %s", name, price, description);
    }
}
