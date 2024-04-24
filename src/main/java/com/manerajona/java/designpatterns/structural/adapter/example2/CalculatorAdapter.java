package com.manerajona.java.designpatterns.structural.adapter.example2;

class CalculatorAdapter implements CalculatorInterface {

    private final Triangle triangle;

    public CalculatorAdapter(Triangle triangle) {
        this.triangle = triangle;
    }

    public double getArea(Rectangle rectangle) {
        rectangle = new Rectangle(triangle.base(), 0.5 * triangle.height());
        Calculator calculator = new Calculator();
        return calculator.getArea(rectangle);
    }
}