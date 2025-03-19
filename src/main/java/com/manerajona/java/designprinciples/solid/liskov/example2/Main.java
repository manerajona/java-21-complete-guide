package com.manerajona.java.designprinciples.solid.liskov.example2;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2, 3);
        System.out.println("Expected area of 6, got " + rectangle.getArea());

        Rectangle square = new Square();
        square.setHeight(10); // anti-pattern
        square.setWidth(10); // anti-pattern
        System.out.println("Expected area of 100, got " + square.getArea());

        square = RectangleFactory.createSquare(10);
        System.out.println("Expected area of 100, got " + square.getArea());

        rectangle = RectangleFactory.createRectangle(2, 3);
        System.out.println("Expected area of 6, got " + rectangle.getArea());
    }
}
