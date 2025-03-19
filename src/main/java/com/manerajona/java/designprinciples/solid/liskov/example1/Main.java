package com.manerajona.java.designprinciples.solid.liskov.example1;

public class Main {
    public static void main(String[] args) {

        Vehicle vehicle = new Bus();
        //vehicle = new Car();
        System.out.println("Speed=" + vehicle.getSpeed());
        System.out.println("Capacity=" + vehicle.getCapacity());
    }
}
