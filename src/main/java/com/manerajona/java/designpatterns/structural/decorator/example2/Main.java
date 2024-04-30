package com.manerajona.java.designpatterns.structural.decorator.example2;

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle(10);
        System.out.println(circle.info());

        ColoredShape blueCircle = new ColoredShape(circle, "blue");
        System.out.println(blueCircle.info());

        ColoredShape blueSquare = new ColoredShape(new Square(20), "blue");
        System.out.println(blueSquare.info());

        TransparentShape myCircle = new TransparentShape(new ColoredShape(new Circle(5), "green"), 50);
        System.out.println(myCircle.info());

        TransparentShape mySquare = new TransparentShape(new Square(5), 50);
        System.out.println(mySquare.info());

        // cannot call myCircle.resize()
    }
}
