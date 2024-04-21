package com.manerajona.java.designpatterns.creationals.singleton.example_doublechecked;

class Singleton {

    // Marking a mutable object field volatile means the object reference is volatile but the object itself is not,
    // and other threads may not see updates to the object state.
    private static volatile Singleton instance = null;

    private int data = 0;

    /**
     * The Singleton Constructor
     * Note that it is private!
     * No client can instantiate a Singleton object!
     */
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {  // we only synchronize the first time through
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void setData(int myData) {
        data = myData;
    }

    public int getData() {
        return data;
    }
}