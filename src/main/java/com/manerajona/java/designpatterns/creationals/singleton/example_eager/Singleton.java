package com.manerajona.java.designpatterns.creationals.singleton.example_eager;

class Singleton {

    // the private reference to the one and only instance
    private static final Singleton instance = new Singleton();

    private int data = 0;

    /**
     * The Singleton Constructor
     * Note that it is private!
     * No client can instantiate a Singleton object!
     */
    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

    public void setData(int myData) {
        data = myData;
    }

    public int getData() {
        return data;
    }
}