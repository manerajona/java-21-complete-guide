package com.manerajona.java.designpatterns.structural.proxy.example4;

public class Main {
    public static void main(String[] args) {
        Drivable car;

        car = new CarProxy(new Driver(12));
        car.drive(); // WARNING

        car = new CarProxy(new Driver(22));
        car.drive(); // OK
    }
}
