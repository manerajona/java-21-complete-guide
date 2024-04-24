package com.manerajona.java.designpatterns.structural.adapter.example4;

public class Main {
    public static void main(String[] args) {
        ClassAdapter ca1 = new ClassAdapter();
        System.out.println("Class Adapter is returning :" + ca1.getInteger());

        ObjectAdapter oa = new ObjectAdapter(new IntegerValue());
        System.out.println("Object Adapter is returning :" + oa.getInteger());
    }
}
