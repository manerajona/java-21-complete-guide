package com.manerajona.java.designpatterns.structural.decorator.example3;

public class Main {
    public static void main(String[] args) {
        MyStringBuilder msb = new MyStringBuilder();
        msb.append("hello").appendLine(" world");
        System.out.println(msb.concat("and this too"));
    }
}
