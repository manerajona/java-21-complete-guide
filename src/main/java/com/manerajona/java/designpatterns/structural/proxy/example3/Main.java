package com.manerajona.java.designpatterns.structural.proxy.example3;

public class Main {
    public static void main(String[] args) {
        Integer number = 10;
        PropertyProxy<Integer> proxy = new PropertyProxy<>(number);
        System.out.println(proxy.getProperty());
    }
}
