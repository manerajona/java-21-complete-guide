package com.manerajona.java.designpatterns.behavioral.command.example2;

import java.util.HashSet;
import java.util.Set;

class Broker {

    private final Set<Order> orderList = new HashSet<>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders(){
        orderList.forEach(Order::execute);
        orderList.clear();
    }
}
