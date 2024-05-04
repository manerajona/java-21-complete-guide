package com.manerajona.java.designpatterns.structural.proxy.example1;

public class Main {
    public static void main(String[] args) {

        Image image = new ProxyImage("someFilename.jpg");

        // image will be loaded from disk
        image.display();
        System.out.println();

        image.display();
    }
}
