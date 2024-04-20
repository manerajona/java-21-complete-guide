package com.manerajona.java.designpatterns.creationals.factory.example3;

class AnimalFactory {

    public enum AnimalType {
        DUCK, TIGER
    }

    public static AnimalInterface getAnimalType(AnimalType type) {
        return switch (type) {
            case DUCK -> new Duck();
            case TIGER -> new Tiger();
        };

    }
}
