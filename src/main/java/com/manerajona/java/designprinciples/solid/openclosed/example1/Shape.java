package com.manerajona.java.designprinciples.solid.openclosed.example1;

interface Shape {
    double calculateArea();
}

record Rectangle(double length, double width) implements Shape {

    @Override
    public double calculateArea() {
        return length * width;
    }
}

record Circle(double radius) implements Shape {

    @Override
    public double calculateArea() {
        return 3.142857142857143 * radius * radius;
    }
}


class AreaCalculator {
    public double calculateShapeArea(Shape shape) {
        return shape.calculateArea();
    }
}

