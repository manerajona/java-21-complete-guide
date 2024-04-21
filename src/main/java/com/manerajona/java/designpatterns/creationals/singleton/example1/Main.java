package com.manerajona.java.designpatterns.creationals.singleton.example1;

public class Main {
    public static void main(String[] args) throws Exception {
        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(111);

        BasicSingleton singleton2 = BasicSingleton.getInstance();

        System.out.println(singleton == singleton2);
        System.out.println(singleton.getValue());
        System.out.println(singleton2.getValue());
    }
}
