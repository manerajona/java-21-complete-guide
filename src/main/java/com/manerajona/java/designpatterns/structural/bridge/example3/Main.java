package com.manerajona.java.designpatterns.structural.bridge.example3;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {

        // The implementation
        ShapeModule shapeModule = new ShapeModule();

        Injector injector = Guice.createInjector(shapeModule);

        // The abstraction
        Circle instance = injector.getInstance(Circle.class);

        instance.setRadius(3);
        instance.draw();

        instance.resize(2);
        instance.draw();
    }
}
