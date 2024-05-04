package com.manerajona.java.designpatterns.structural.proxy.example2;

class ForbiddenException extends RuntimeException {
    public ForbiddenException(String message) {
        super(message);
    }
}

interface Internet {
    void connectTo(String serverHost) throws ForbiddenException;
}

class Wireless implements Internet {
    @Override
    public void connectTo(String serverHost) {
        System.out.println("Connecting to " + serverHost);
    }
}
