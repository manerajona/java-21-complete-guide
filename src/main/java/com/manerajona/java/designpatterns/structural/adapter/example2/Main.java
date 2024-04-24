package com.manerajona.java.designpatterns.structural.adapter.example2;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(4, 5);
        printArea(new Calculator(), rectangle);

        Triangle triangle = new Triangle(4, 5);
        CalculatorAdapter adapter = new CalculatorAdapter(triangle);
        printArea(adapter, null);
    }

    static void printArea(CalculatorInterface calculator, Rectangle rectangle) {
        System.out.println("The area of a rectangle is " + calculator.getArea(rectangle));
    }
}
