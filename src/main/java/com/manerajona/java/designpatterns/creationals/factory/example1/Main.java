package com.manerajona.java.designpatterns.creationals.factory.example1;

public class Main {
    public static void main(String[] args) {
        //get an object of Circle and call its draw method.
        {
            AbstractShapeFactory factory = new CircleFactory();
            Shape circle = factory.getShape();
            circle.draw();
        }
        //get an object of Rectangle and call its draw method.
        {
            Shape rectangle = new RectangleFactory().getShape();
            rectangle.draw();
        }
        //get an object of Square and call its draw method.
        {
            Shape square = new SquareFactory().getShape();
            square.draw();
        }
    }
}