package com.manerajona.java.designpatterns.structural.adapter.example3;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new RectangleImpl(4, 5);
        printArea(rectangle);

        Square square = new SquareImpl(5);
        SquareToRectangleAdapter adapter = new SquareToRectangleAdapter(square);
        printArea(adapter);
    }

    static void printArea(Rectangle rectangle) {
        System.out.println("The area of a rectangle is " + rectangle.getArea());
    }
}
