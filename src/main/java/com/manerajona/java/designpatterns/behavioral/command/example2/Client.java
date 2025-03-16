package com.manerajona.java.designpatterns.behavioral.command.example2;

public class Client {
    public static void main(String[] args) {
        Stock metaStock = new Stock("META", 1000);

        BuyStock buyStockOrder = new BuyStock(metaStock);
        SellStock sellStockOrder = new SellStock(metaStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
