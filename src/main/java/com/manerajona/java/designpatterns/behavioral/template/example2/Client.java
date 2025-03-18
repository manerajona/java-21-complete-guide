package com.manerajona.java.designpatterns.behavioral.template.example2;

public class Client {
    public static void main(String[] args) {
        OrderProcessTemplate netOrder = new NetOrder();
        netOrder.processOrder(true);

        System.out.println("---------------------------------------------");

        OrderProcessTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder(false);
    }
}
