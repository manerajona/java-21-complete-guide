package com.manerajona.java.designpatterns.creationals.factory.example1;

public abstract class AbstractShapeFactory {

    // This method implements the concrete implementation of the object creation
    protected abstract Shape factoryMethod();

    // This is the method that The Client uses to create a Shape
    public Shape getShape() {
        return factoryMethod();
    }
}

final class RectangleFactory extends AbstractShapeFactory {
    protected Shape factoryMethod() {
        return new Rectangle();
    }
}

final class SquareFactory extends AbstractShapeFactory {
    protected Shape factoryMethod() {
        return new Square();
    }
}

final class CircleFactory extends AbstractShapeFactory {
    protected Shape factoryMethod() {
        return new Circle();
    }
}