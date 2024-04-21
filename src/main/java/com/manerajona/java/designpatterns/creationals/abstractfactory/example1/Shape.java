package com.manerajona.java.designpatterns.creationals.abstractfactory.example1;

interface Shape {
    void draw();
}

enum ShapeType {
    RECTANGLE, SQUARE, CIRCLE
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}