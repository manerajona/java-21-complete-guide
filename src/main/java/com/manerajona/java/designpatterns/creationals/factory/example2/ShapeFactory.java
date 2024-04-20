package com.manerajona.java.designpatterns.creationals.factory.example2;

public class ShapeFactory {

    private ShapeFactory() {
        // a private constructor avoids accidental instantiation
    }

    public static Shape getShape(ShapeType shapeType) {
        return switch (shapeType) {
            case CIRCLE -> new Circle();
            case RECTANGLE -> new Rectangle();
            case SQUARE -> new Square();
        };
    }
}