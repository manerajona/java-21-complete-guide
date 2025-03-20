package com.manerajona.java.designpatterns.behavioral.strategy.example5;

interface TransportStrategy {
    void selectTransport();
}

class Bus implements TransportStrategy {

    @Override
    public void selectTransport() {
        System.out.println("User selected Bus");
    }
}

class Taxi implements TransportStrategy {

    @Override
    public void selectTransport() {
        System.out.println("User selected Taxi");
    }
}

class Bike implements TransportStrategy {

    @Override
    public void selectTransport() {
        System.out.println("User selected Bike");
    }
}