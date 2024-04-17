package com.manerajona.java.designprinciples.solid.openclosed.example1;

public interface Shape {
    double calculateArea();
}

class Rectangle implements Shape {
    public double length;
    public double width;

    public double calculateArea() {
        return length * width;
    }
}

class Circle implements Shape {
    public double radius;

    public double calculateArea() {
        return ((double) 22 / 7) * radius * radius;
    }
}


class AreaCalculator {
    public double calculateShapeArea(Shape shape) {
        return shape.calculateArea();
    }
}

