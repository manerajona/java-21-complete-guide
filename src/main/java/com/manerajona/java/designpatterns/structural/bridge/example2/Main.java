package com.manerajona.java.designpatterns.structural.bridge.example2;

public class Main {
    public static void main(String[] args) {

        // The implementation
        ColorInterface green = new GreenColor();
        ColorInterface red = new RedColor();

        //Coloring Green to Triangle
        System.out.println("\nColoring Triangle:");
        Shape triangleShape = new Triangle(green);
        triangleShape.drawShape(20);
        triangleShape.modifyBorder(20, 3);

        //Coloring Red to Rectangle
        System.out.println("\n\nColoring Rectangle :");
        Shape rectangleShape = new Rectangle(red);
        rectangleShape.drawShape(50);
        rectangleShape.modifyBorder(50, 2);
    }
}