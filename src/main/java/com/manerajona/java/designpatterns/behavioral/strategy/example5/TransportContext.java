package com.manerajona.java.designpatterns.behavioral.strategy.example5;

record TransportContext(TransportStrategy transportStrategy) {
    public void chooseTransport() {
        transportStrategy.selectTransport();
    }
}
