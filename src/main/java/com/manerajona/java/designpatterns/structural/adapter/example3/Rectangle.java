package com.manerajona.java.designpatterns.structural.adapter.example3;

interface Rectangle {
    double getArea();

    double length();

    double width();
}

record RectangleImpl(double length, double width) implements Rectangle {
    @Override
    public double getArea() {
        return length * width;
    }
}

