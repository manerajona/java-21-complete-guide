package com.manerajona.java.programming.scope.newnamespace;

interface Accessible { // at toṕ level default is only access in this namespace
    int CONSTANT = 100;
    public static final int SOME_CONSTANT = 100; // all attributes are public static final by default
    void  method();
    public abstract void sameMethod(); // all methods are public abstract
}
