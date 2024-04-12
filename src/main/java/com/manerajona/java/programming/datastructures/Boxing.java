package com.manerajona.java.programming.datastructures;

public class Boxing {
    public static void main(String[] args) {

        // Autoboxing

        // In some cases you need to use a object wrapper
        Integer intObject;
        Double doubleObject;

        // This is what Autoboxing is about...
        intObject = Integer.valueOf(54);
        doubleObject = Double.valueOf(54.01d);

        // Unboxing

        // Is the inverse process...
        int i = intObject.intValue();
        double d = doubleObject.doubleValue();

        // But Java do things more easy
        intObject = 54; // Autoboxing
        int j = intObject; // Unboxing

        // IMPORTANT To being aware that behind the scenes JAVA
        // is doing the same for boxing that we do in the beginning!
    }

}
