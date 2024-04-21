package com.manerajona.java.designpatterns.creationals.singleton.example4;

public class Main {
    public static void main(String[] args) {
        Captain c1 = Captain.getInstance();
        Captain c2 = Captain.getInstance();
        if (c1 == c2)
            System.out.println("c1 and c2 are the same instance");
    }
}