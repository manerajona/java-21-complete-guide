package com.manerajona.java.designpatterns.creationals.abstractfactory.example1;

public class FactoryProducer {

    public enum Type {
        SHAPE, COLOR
    }

    public static AbstractFactory getFactory(Type choice) {
        return switch (choice) {
            case SHAPE -> new ShapeFactory();
            case COLOR -> new ColorFactory();
        };
    }
}