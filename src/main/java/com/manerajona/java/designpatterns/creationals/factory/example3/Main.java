package com.manerajona.java.designpatterns.creationals.factory.example3;

public class Main {
    public static void main(String[] args) throws Exception {

        AnimalInterface duckType = AnimalFactory.getAnimalType(AnimalFactory.AnimalType.DUCK);
        duckType.Speak();

        AnimalInterface tigerType = AnimalFactory.getAnimalType(AnimalFactory.AnimalType.TIGER);
        tigerType.Speak();
    }
}
