package com.manerajona.java.designpatterns.creationals.prototype.example1;

public class Main {
    public static void main(String[] args) {

        ShapeCache.loadCache();

        Shape clonedShape = ShapeCache.getShape("1");
        System.out.println("\nShape : " + clonedShape.getType());
        clonedShape.draw();

        Shape clonedShape2 = ShapeCache.getShape("2");
        System.out.println("\nShape : " + clonedShape2.getType());
        clonedShape2.draw();

        Shape clonedShape3 = ShapeCache.getShape("3");
        System.out.println("\nShape : " + clonedShape3.getType());
        clonedShape3.draw();
    }
}