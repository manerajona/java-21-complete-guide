package com.manerajona.java.designpatterns.creationals.singleton.example_billpugh;

public class Main {
    public static void main(String[] args) {

        Singleton s1 = Singleton.getInstance();
        // set the data value
        s1.setData(99);
        System.out.println("First reference: " + s1);
        System.out.println("Singleton data value is: " + s1.getData());

        // Get another reference to the Singleton.
        // Is it the same object?
        Singleton s2 = Singleton.getInstance();
        System.out.println("\nSecond reference: " + s2);
        System.out.println("Singleton data value is: " + s2.getData());
    }
}
