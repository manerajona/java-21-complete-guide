package com.manerajona.java.designpatterns.structural.decorator.example6;

public class Main {
    public static void main(String[] args) {

        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        Shape redCircle = new RedShapeDecorator(circle);

        Shape blueRectangle = new BlueShapeDecorator(rectangle);

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nRectangle with normal border");
        rectangle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        blueRectangle.draw();
    }
}
