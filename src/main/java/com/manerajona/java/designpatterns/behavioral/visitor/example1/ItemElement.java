package com.manerajona.java.designpatterns.behavioral.visitor.example1;

interface ItemElement {

    int accept(ShoppingCartVisitor visitor);
}

record Book(String name, int price, String isbnNumber) implements ItemElement {
    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}

record Fruit(String name, int pricePerKg, int weight) implements ItemElement {
    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}
