package com.manerajona.java.designprinciples.delegation;

public class Main {
    // To the outside world it looks like Printer actually prints
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print();
    }
}
