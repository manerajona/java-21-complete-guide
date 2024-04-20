package com.manerajona.java.designpatterns.creationals.factory.example4;

import java.util.Objects;

enum CoordinateSystem {
    CARTESIAN, POLAR
}

class Point {
    double x, y;

    private Point(double x, double y) { // Restrict access from API
        this.x = x;
        this.y = y;
    }

    public Point(double a, double b, // names do not communicate intent
                 CoordinateSystem cs) {
        // Anti-pattern
        if (Objects.requireNonNull(cs) == CoordinateSystem.CARTESIAN) {
            this.x = a;
            this.y = b;
        } else if (cs == CoordinateSystem.POLAR) {
            this.x = a * Math.cos(b);
            this.y = a * Math.sin(b);
        }
    }

    // singleton field
    public static final Point ORIGIN = new Point(0, 0);

    // Subclass of Point
    public static class Factory {

        public static Point newCartesianPoint(double x, double y) {
            return new Point(x, y);
        }

        public static Point newPolarPoint(double rho, double theta) {
            return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
        }
    }
}


