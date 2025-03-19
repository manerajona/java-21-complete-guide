package com.manerajona.java.designprinciples.solid.liskov.example1;

abstract class Vehicle {
    abstract int getSpeed();

    abstract int getCapacity();
}

class Car extends Vehicle {

    int getSpeed() {
        return 120;
    }

    int getCapacity() {
        return 4;
    }

    boolean sHatchBack() {
        return true;
    }
}

class Bus extends Vehicle {

    int getSpeed() {
        return 90;
    }

    int getCapacity() {
        return 30;
    }

    String getEmergencyExitLoc() {
        return "";
    }
}