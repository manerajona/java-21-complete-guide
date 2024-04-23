package com.manerajona.java.designpatterns.creationals.prototype.example2;

public class Main {

    public static void main(String[] args) {
        BasicCarCache.loadCache();

        BasicCar bc1 = BasicCarCache.getCar("Green Nano");
        //Price will be more than 100000 for sure
        bc1.setPrice(BasicCar.generatePrice());
        System.out.println("Car is: " + bc1.getModelName() + " and it’s price is Rs." + bc1.price());

        bc1 = BasicCarCache.getCar("Ford Yellow");
        //Price will be more than 500000 for sure
        bc1.setPrice(BasicCar.generatePrice());
        System.out.println("Car is: " + bc1.getModelName() + " and it’s price is Rs." + bc1.price());
    }
}
