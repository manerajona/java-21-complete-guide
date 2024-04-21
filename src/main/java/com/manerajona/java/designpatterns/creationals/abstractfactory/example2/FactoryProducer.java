package com.manerajona.java.designpatterns.creationals.abstractfactory.example2;

public class FactoryProducer {

    public enum Type {
        HOLLYWOOD, BOLLYWOOD
    }

    static MovieFactoryInterface getFactory(Type choice) {
        return switch (choice) {
            case HOLLYWOOD -> new HollyWoodMovieFactory();
            case BOLLYWOOD -> new BollyWoodMovieFactory();
        };
    }
}
