package com.manerajona.java.designpatterns.structural.adapter.example1;

interface Turkey {
    void gobble();

    void fly();
}

class WildTurkey implements Turkey {
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    public void fly() {
        System.out.println("I am flying a short distance");
    }
}