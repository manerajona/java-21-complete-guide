package com.manerajona.java.designprinciples.delegation;

class RealPrinter {
    // the "delegate"
    void print() {
        System.out.println("The Delegate");
    }
}

class Printer {
    // the "delegator"
    RealPrinter p = new RealPrinter();

    // create the delegate
    void print() {
        p.print();  // delegation
    }
}