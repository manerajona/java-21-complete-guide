package com.manerajona.java.designpatterns.structural.adapter.example1;

// The Target
interface Duck {
    void quack();

    void fly();
}

// The Adaptee
class MallardDuck implements Duck {
    public void quack() {
        System.out.println("Quack");
    }

    public void fly() {
        System.out.println("I am flying");
    }
}