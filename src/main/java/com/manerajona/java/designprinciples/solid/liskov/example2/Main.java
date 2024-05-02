package com.manerajona.java.designprinciples.solid.liskov.example2;

public class Main {
    // maybe conform to ++
    static void useIt(Rectangle r) {
        int width = r.getWidth();
        r.setHeight(10);
        System.out.println("Expected area of " + (width * 10) + ", got " + r.getArea());
    }

    public static void main(String[] args) {
        Rectangle rc = new Rectangle(2, 3);
        useIt(rc);

        Rectangle sq = new Square();
        sq.setHeight(5); // anti-pattern
        sq.setWidth(10); // anti-pattern
        useIt(sq);

        sq = RectangleFactory.newSquare(10);
        useIt(sq);

        rc = RectangleFactory.newRectangle(2, 3);
        useIt(rc);
    }
}
