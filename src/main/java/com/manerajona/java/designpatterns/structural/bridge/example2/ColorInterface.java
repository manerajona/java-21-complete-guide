package com.manerajona.java.designpatterns.structural.bridge.example2;

public interface ColorInterface {
    void fillWithColor(int border);
}

class RedColor implements ColorInterface {
    @Override
    public void fillWithColor(int border) {
        System.out.print("Red color with " + border + " inch border");
    }
}

class GreenColor implements ColorInterface {
    @Override
    public void fillWithColor(int border) {
        System.out.print("Green color with " + border + " inch border");
    }
}