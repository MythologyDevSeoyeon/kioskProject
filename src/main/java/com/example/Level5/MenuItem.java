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

    //getter
    public String getName() {
        return name;
    }

    //getter
    public double getPrice(){
        return price;
    }

    //getter
    public String getDescription(){
        return description;
    }
}

