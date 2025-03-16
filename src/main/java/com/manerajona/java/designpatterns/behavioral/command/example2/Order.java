package com.manerajona.java.designpatterns.behavioral.command.example2;

interface Order {
    void execute();
}

class BuyStock implements Order {
    private final Stock myStock;

    public BuyStock(Stock someStock) {
        myStock = someStock;
    }

    public void execute() {
        myStock.buy();
    }
}

class SellStock implements Order {
    private final Stock myStock;

    public SellStock(Stock someStock){
        this.myStock = someStock;
    }

    public void execute() {
        myStock.sell();
    }
}

