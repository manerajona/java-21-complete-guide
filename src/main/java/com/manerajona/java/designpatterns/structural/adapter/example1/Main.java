package com.manerajona.java.designpatterns.structural.adapter.example1;

public class Main {
    public static void main(String[] args) {

        Duck duck = new MallardDuck();
        System.out.println("\nThe Duck says ....");
        testDuck(duck);

        Turkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        System.out.println("\nThe turkey says ....");
        testDuck(turkeyAdapter);
    }

    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}