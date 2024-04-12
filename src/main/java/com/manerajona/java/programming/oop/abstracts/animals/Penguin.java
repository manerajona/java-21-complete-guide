package com.manerajona.java.programming.oop.abstracts.animals;

public class Penguin extends Bird{

    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("Penguins are not very good doing that");
    }
}
