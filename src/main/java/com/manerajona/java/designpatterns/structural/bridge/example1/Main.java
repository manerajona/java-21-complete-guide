package com.manerajona.java.designpatterns.structural.bridge.example1;

public class Main {
    public static void main(String[] args) {

        // The implementation
        Workshop produce = new Produce();
        Workshop assemble = new Assemble();

        // The abstraction
        Vehicle car = new Car(produce, assemble);
        car.manufacture();

        Vehicle bike = new Bike(produce, assemble);
        bike.manufacture();
    }
}
