package com.manerajona.java.designpatterns.behavioral.visitor.example2;

abstract class Visitor {

    protected double totalPostageForCart;

    abstract void visit(Book book);

    abstract void visit(CD cd);

    abstract void visit(DVD dvd);

    public double getTotalPostage() {
        return totalPostageForCart;
    }
}

class USPostageVisitor extends Visitor {

    private static final double MIN_PRICE_FOR_FREE_SHIPPING = 20.;

    public void visit(Book book) {
        if (book.price() < MIN_PRICE_FOR_FREE_SHIPPING) {
            totalPostageForCart += book.weight() * 2;
        }
    }

    public void visit(CD cd) {
        if (cd.price() < MIN_PRICE_FOR_FREE_SHIPPING) {
            totalPostageForCart += cd.weight() * 2.5;
        }
    }

    public void visit(DVD dvd) {
        if (dvd.price() < MIN_PRICE_FOR_FREE_SHIPPING) {
            totalPostageForCart += dvd.weight() * 3;
        }
    }
}

class SouthAmericaPostageVisitor extends Visitor {

    private static final double MIN_PRICE_FOR_FREE_SHIPPING = 30.;
    private static final double SHIPPING_PRICE_FOR_SOUTH_AMERICA = 10;

    public void visit(Book book) {
        if (book.price() < MIN_PRICE_FOR_FREE_SHIPPING) {
            totalPostageForCart += (book.weight() * 2) + SHIPPING_PRICE_FOR_SOUTH_AMERICA;
        }
    }

    public void visit(CD cd) {
        if (cd.price() < MIN_PRICE_FOR_FREE_SHIPPING) {
            totalPostageForCart += (cd.weight() * 2.5) + SHIPPING_PRICE_FOR_SOUTH_AMERICA;
        }
    }

    public void visit(DVD dvd) {
        if (dvd.price() < MIN_PRICE_FOR_FREE_SHIPPING) {
            totalPostageForCart += (dvd.weight() * 3) + SHIPPING_PRICE_FOR_SOUTH_AMERICA;
        }
    }
}





