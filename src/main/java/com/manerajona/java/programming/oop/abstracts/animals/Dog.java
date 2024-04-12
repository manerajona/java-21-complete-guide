package com.manerajona.java.programming.oop.abstracts.animals;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("Dog eating...");
    }

    @Override
    public void breathe() {
        System.out.println("Dog breathing...");
    }
}
