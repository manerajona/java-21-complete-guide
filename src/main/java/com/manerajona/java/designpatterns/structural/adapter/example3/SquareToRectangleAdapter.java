package com.manerajona.java.designpatterns.structural.adapter.example3;

class SquareToRectangleAdapter implements Rectangle {

    private final Square square;

    SquareToRectangleAdapter(Square square) {
        this.square = square;
    }

    @Override
    public double getArea() {
        return square.side() * square.side();
    }

    @Override
    public double length() {
        return square.side();
    }

    @Override
    public double width() {
        return square.side();
    }
}