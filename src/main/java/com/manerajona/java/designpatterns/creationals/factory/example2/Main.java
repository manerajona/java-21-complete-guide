package com.manerajona.java.designpatterns.creationals.factory.example2;

public class Main {
    public static void main(String[] args) {

        //get an object of Circle and call its draw method.
        Shape circle = ShapeFactory.getShape(ShapeType.CIRCLE);
        circle.draw();

        //get an object of Rectangle and call its draw method.
        Shape rectangle = ShapeFactory.getShape(ShapeType.RECTANGLE);
        rectangle.draw();

        //get an object of Square and call its draw method.
        Shape square = ShapeFactory.getShape(ShapeType.SQUARE);
        square.draw();
    }
}