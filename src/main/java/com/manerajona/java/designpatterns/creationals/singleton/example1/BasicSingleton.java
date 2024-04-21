package com.manerajona.java.designpatterns.creationals.singleton.example1;

import java.io.Serial;
import java.io.Serializable;

class BasicSingleton implements Serializable {
    private static final BasicSingleton INSTANCE = new BasicSingleton();
    private int value = 0;

    // cannot new this class, however
    // * instance can be created deliberately (reflection)
    // * instance can be created accidentally (serialization)
    private BasicSingleton() {
        System.out.println("Singleton is initializing");
    }

    // generated getter
    public static BasicSingleton getInstance() {
        return INSTANCE;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // required for correct serialization
    // readResolve is used for _replacing_ the object read from the stream
    @Serial
    protected Object readResolve() {
        return INSTANCE;
    }
}