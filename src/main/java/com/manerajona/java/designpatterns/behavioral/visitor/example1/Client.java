package com.manerajona.java.designpatterns.behavioral.visitor.example1;

import java.util.Arrays;

public class Client {

    public static void main(String[] args) {
        ItemElement[] items = new ItemElement[]{
                new Book("Hamlet", 20, "1234"),
                new Book("Quixote", 100, "5678"),
                new Fruit("Banana", 10, 2),
                new Fruit("Apple", 5, 5)};

        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();

        final int total = Arrays.stream(items).mapToInt(item -> item.accept(visitor)).sum();
        System.out.println("Total Cost = " + total);
    }
}
