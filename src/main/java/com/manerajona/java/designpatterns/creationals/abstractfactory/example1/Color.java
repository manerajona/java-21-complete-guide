package com.manerajona.java.designpatterns.creationals.abstractfactory.example1;

interface Color {
    void fill();
}

enum ColorType {
    RED, GREEN, BLUE
}

class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}

class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}

class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}