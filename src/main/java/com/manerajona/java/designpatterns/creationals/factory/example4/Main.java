package com.manerajona.java.designpatterns.creationals.factory.example4;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(2, 3, CoordinateSystem.CARTESIAN);
        //point = new Point(2,3); // Not allowed
        Point origin = Point.ORIGIN;

        Point point1 = Point.Factory.newCartesianPoint(1, 2);
        Point point2 = Point.Factory.newPolarPoint(1, 2);
    }
}
