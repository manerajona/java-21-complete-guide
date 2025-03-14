package com.manerajona.java.designprinciples.dependencyinjection.basic;

interface Service {
    void write(String message);
}

class ServiceA implements Service {
    @Override
    public void write(String message) {
        System.out.println("Hello World");
    }
}