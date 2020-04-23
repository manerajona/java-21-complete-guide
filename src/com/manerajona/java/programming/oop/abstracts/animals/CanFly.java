package com.manerajona.java.programming.oop.abstracts.animals;

public interface CanFly {
    void fly();

    default void openWigs() {
        System.out.println("Open Wings");
    }
}
