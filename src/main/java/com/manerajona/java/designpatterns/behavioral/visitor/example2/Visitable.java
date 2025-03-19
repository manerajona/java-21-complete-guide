package com.manerajona.java.designpatterns.behavioral.visitor.example2;

import java.util.function.Consumer;

record Book(double price, double weight) implements Consumer<Visitor> {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

record CD(double price, double weight) implements Consumer<Visitor> {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

record DVD(double price, double weight) implements Consumer<Visitor> {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}