package com.manerajona.java.designpatterns.behavioral.strategy.example5;

public class Client {
    public static void main(String[] args) {
        TransportContext ctx;

        ctx = new TransportContext(new Bus());
        ctx.chooseTransport();

        ctx = new TransportContext(new Taxi());
        ctx.chooseTransport();

        ctx = new TransportContext(new Bike());
        ctx.chooseTransport();
    }
}
