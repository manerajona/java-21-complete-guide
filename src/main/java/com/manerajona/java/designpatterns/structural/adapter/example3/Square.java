package com.manerajona.java.designpatterns.structural.adapter.example3;

interface Square {
    double side();
}

record SquareImpl(double side) implements Square {
}