package com.manerajona.java.designpatterns.creationals.builder.example1;

public class Director {

    public void construct(BuilderInterface builder) {
        builder.buildBody();
        builder.insertWheels();
        builder.addHeadlights();
    }
}