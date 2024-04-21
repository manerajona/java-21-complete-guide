package com.manerajona.java.designpatterns.creationals.singleton.example2;

public class Main {
    public static void main(String[] args) {

        EnumBasedSingleton singleton = EnumBasedSingleton.INSTANCE;
        singleton.setValue(111);

        EnumBasedSingleton singleton2 = EnumBasedSingleton.INSTANCE;

        System.out.println(singleton.getValue());
        System.out.println(singleton2.getValue());
    }
}
