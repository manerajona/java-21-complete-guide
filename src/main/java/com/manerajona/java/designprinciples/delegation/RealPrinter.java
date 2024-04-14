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

class Tester {
    // To the outside world it looks like Printer actually prints
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print();
    }
}