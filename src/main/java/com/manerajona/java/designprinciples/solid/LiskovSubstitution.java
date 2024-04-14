package com.manerajona.java.designprinciples.solid;

public class LiskovSubstitution {
    // maybe conform to ++
    static void useIt(Rectangle r)
    {
        int width = r.getWidth();
        r.setHeight(10);
        System.out.println("Expected area of " + (width*10) + ", got " + r.getArea());
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

        rc = RectangleFactory.newRectangle(2,3);
        useIt(rc);
    }
}

class Rectangle
{
    protected int width, height;

    public Rectangle() {}

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() { return (width * height); }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    public boolean isSquare()
    {
        return width == height;
    }
}

class Square extends Rectangle
{
    public Square() {
    }

    public Square(int size) {
        width = height = size;
    }

    @Override
    public void setWidth(int width) { // anti-pattern
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) { // anti-pattern
        super.setHeight(height);
        super.setWidth(height);
    }
}

class RectangleFactory
{
    public static Rectangle newSquare(int side)
    {
        return new Rectangle(side, side);
    }

    public static Rectangle newRectangle(int width, int height)
    {
        return new Rectangle(width, height);
    }
}
