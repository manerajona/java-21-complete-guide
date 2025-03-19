package com.manerajona.java.designpatterns.behavioral.visitor.example1;

interface ShoppingCartVisitor {
    int visit(Book book);

    int visit(Fruit fruit);
}

class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

    @Override
    public int visit(Book book) {
        final int discount = (book.price() > 50) ? 5 : 0;
        final int cost = book.price() - discount;
        System.out.println("Item name=" + book.name() + ", isbn=" + book.isbnNumber() + ", cost=" + cost);
        return cost;
    }

    @Override
    public int visit(Fruit fruit) {
        final int cost = fruit.pricePerKg() * fruit.weight();
        System.out.println("Item name=" + fruit.name() + ", cost=" + cost);
        return cost;
    }
}
