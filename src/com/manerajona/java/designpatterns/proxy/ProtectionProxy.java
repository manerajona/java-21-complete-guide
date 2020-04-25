package com.manerajona.java.designpatterns.proxy;

class ProtectionProxy {
    public static void main(String[] args) {
        Drivable car;
        {
            car = new CarProxy(new Driver(12));
            car.drive(); // WARNING

            car = new CarProxy(new Driver(22));
            car.drive(); // OK
        }
    }
}

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
        if (driver.age >= 17)
            super.drive();
        else
            System.out.println("Driver too young");
    }
}

class Driver {
    public int age;

    public Driver(int age) {
        this.age = age;
    }
}