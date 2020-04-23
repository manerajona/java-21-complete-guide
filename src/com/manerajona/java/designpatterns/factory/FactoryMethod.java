package com.manerajona.java.designpatterns.factory;

public class FactoryMethod {

    public static void main(String[] args) {
        Point point = new Point(2, 3, CoordinateSystem.CARTESIAN);
        //point = new Point(2,3); // Not allowed
        Point origin = Point.ORIGIN;

        Point point1 = Point.Factory.newCartesianPoint(1, 2);
        Point point2 = Point.Factory.newPolarPoint(1, 2);
    }
}

enum CoordinateSystem {
    CARTESIAN, POLAR
}

class Point {
    private double x, y;

    private Point(double x, double y) { // Restrict access from API
        this.x = x;
        this.y = y;
    }

    public Point(double a, double b, // names do not communicate intent
                 CoordinateSystem cs) {
        // Anti-pattern
        switch (cs) {
            case CARTESIAN:
                this.x = a;
                this.y = b;
                break;
            case POLAR:
                this.x = a * Math.cos(b);
                this.y = a * Math.sin(b);
                break;
        }
    }

    // steps to add a new system
    // 1. augment CoordinateSystem
    // 2. change ctor

    // singleton field
    public static final Point ORIGIN = new Point(0, 0);

    // factory method
    public static Point newCartesianPoint(double x, double y) {
        return new Point(x, y);
    }

    public static Point newPolarPoint(double rho, double theta) {
        return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
    }

    public static class Factory // Sub-class
    {
        public static Point newCartesianPoint(double x, double y) {
            return new Point(x, y);
        }
        public static Point newPolarPoint(double rho, double theta) {
            return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
        }
    }
}


