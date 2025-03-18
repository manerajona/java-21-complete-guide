package com.manerajona.java.designpatterns.behavioral.strategy.example1;

import java.util.ArrayList;
import java.util.List;

record Item(String upcCode, int price) {
}

class ShoppingCart {
    private final List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public void pay(PaymentStrategy paymentMethod) {
        final int amount = items.stream().mapToInt(Item::price).sum();
        paymentMethod.pay(amount);
    }
}
