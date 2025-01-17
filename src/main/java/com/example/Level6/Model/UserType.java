package com.example.Level6.Model;

public enum UserType {
    VETERAN("국가유공자", 10),    // 국가유공자: 10% 할인
    SOLDIER("군인", 5),     // 군인: 5% 할인
    STUDENT("학생", 3),     // 학생: 3% 할인
    GENERAL("일반", 0);     // 일반: 할인 없음

    private final String name;
    private final int discountPercent;

    UserType(String name, int discountPercent){
        this.name = name;
        this.discountPercent = discountPercent;
    }

    public String getName(){
        return  name;
    }

    public int getDiscountPercent(){
        return discountPercent;
    }
}
