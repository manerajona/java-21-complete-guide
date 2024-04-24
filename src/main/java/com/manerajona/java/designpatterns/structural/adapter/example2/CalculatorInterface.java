package com.manerajona.java.designpatterns.structural.adapter.example2;

// The Target
interface CalculatorInterface {
    double getArea(Rectangle r);
}

// The Adaptee
class Calculator implements CalculatorInterface {
    @Override
    public double getArea(Rectangle rectangle) {
        return rectangle.length() * rectangle.width();
    }
}