package com.manerajona.java.designpatterns.structural.bridge.example1;

abstract class Vehicle {
    protected Workshop workshop1;
    protected Workshop workshop2;

    protected Vehicle(Workshop workshop1, Workshop workshop2) {
        this.workshop1 = workshop1;
        this.workshop2 = workshop2;
    }

    abstract void manufacture();
}

class Car extends Vehicle {

    public Car(Workshop w1, Workshop w2) {
        super(w1, w2);
    }

    @Override
    public void manufacture() {
        System.out.print("\nCar ");
        workshop1.work();
        workshop2.work();
    }
}

class Bike extends Vehicle {

    public Bike(Workshop w1, Workshop w2) {
        super(w1, w2);
    }

    @Override
    public void manufacture() {
        System.out.print("\nBike ");
        workshop1.work();
        workshop2.work();
    }
}