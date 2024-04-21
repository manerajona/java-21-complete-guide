package com.manerajona.java.designpatterns.creationals.singleton.example2;

// you cannot inherit from this
enum EnumBasedSingleton {
    INSTANCE;

    // field values not serialized!
    int value;

    // enums are inherently serializable (but what good is that?)
    // reflection not a problem, guaranteed 1 instance in JVM

    // enum type already has a private ctor by default,
    // but if you need to initialize things...
    EnumBasedSingleton() {
        value = 42;
    }

    public int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }
}