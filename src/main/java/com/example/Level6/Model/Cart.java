package com.example.Level6.Model;

import java.util.Collections;
import java.util.List;

public class Cart {

    //필드
    private final List<MenuItem> orderList;

    //생성자
    public Cart(List<MenuItem> orderList) {
        this.orderList = orderList;
    }

    //getter
    public List<MenuItem> getOrderList() {
        return Collections.unmodifiableList(orderList);
    }

    //주문 상품 추가
    public void addItem(MenuItem item) {
        orderList.add(item);
    }

    //카트
    public void clearItem() {
        orderList.clear();
    }

    public boolean checkItem() {
        return !orderList.isEmpty(); //장바구니가 비었는지 확인
    }

}
