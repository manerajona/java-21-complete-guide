package com.manerajona.java.designpatterns.structural.decorator.example6;

abstract class ColorShapeDecorator implements Shape {

    protected String color;
    protected Shape shape;

    protected ColorShapeDecorator(String color, Shape shape) {
        this.color = color;
        this.shape = shape;
    }

    @Override
    public void draw() {
        System.out.println("Border Color: " + color);
        shape.draw();
    }
}

class RedShapeDecorator extends ColorShapeDecorator {

    public RedShapeDecorator(Shape shape) {
        super("Red", shape);
    }
}

class BlueShapeDecorator extends ColorShapeDecorator {

    public BlueShapeDecorator(Shape shape) {
        super("Blue", shape);
    }
}