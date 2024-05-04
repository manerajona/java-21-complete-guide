package com.manerajona.java.designpatterns.structural.proxy.example4;

interface Drivable {
    void drive();
}

class Car implements Drivable {

    protected Driver driver;

    public Car(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void drive() {
        System.out.println("Car being driven");
    }
}

class CarProxy extends Car {

    public CarProxy(Driver driver) {
        super(driver);
    }

    @Override
    public void drive() {
        if (driver.age() >= 17) {
            super.drive();
        } else {
            System.out.println("Driver too young");
        }
    }
}

record Driver(int age) {
}