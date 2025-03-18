package com.manerajona.java.designpatterns.behavioral.template.example1;

public class Client {
    public static void main(String[] args) {
        HouseTemplate houseType;

        houseType = new WoodenHouse().buildHouse();
        System.out.println(houseType);

        System.out.println("---------------------------------------------");

        houseType = new GlassHouse().buildHouse();
        System.out.println(houseType);
    }
}
