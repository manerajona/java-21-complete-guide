package com.manerajona.java.designpatterns.creationals.singleton.example_billpugh;

public class Singleton {

    private int data = 0;

    /**
     * The Singleton Constructor
     * Note that it is private!
     * No client can instantiate a Singleton object!
     */
    private Singleton() {
    }

    private static class SingletonHelper {
        // Nested class is referenced after getInstance() is called
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHelper.instance;
    }

    public void setData(int myData) {
        data = myData;
    }

    public int getData() {
        return data;
    }
}