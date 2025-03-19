package com.manerajona.java.designprinciples.solid.interfacesegregation.example2;

import java.io.IOException;

record Document(String content) {
}

/*
    ANTI-PATTERN WAY
 */

interface Machine {
    void print(Document d);

    void fax(Document d) throws IOException;

    void scan(Document d) throws IOException;
}

// ok if you need a multifunction machine
class MultiFunctionPrinter implements Machine {
    public void print(Document d) {
        // printing document
    }

    public void fax(Document d) {
        // faxing document
    }

    public void scan(Document d) {
        // scanning document
    }
}

class OldFashionedPrinter implements Machine {
    public void print(Document d) {
        // yep
    }

    public void fax(Document d) throws IOException {
        throw new IOException();
    }

    public void scan(Document d) throws IOException {
        throw new IOException();
    }
}

/*
    ISP WAY
 */

interface Printer {
    void print(Document d) throws IOException;
}

interface Scanner {
    void scan(Document d) throws IOException;
}

class JustAPrinter implements Printer {
    public void print(Document d) {

    }
}

class Photocopier implements Printer, Scanner {
    public void print(Document d) throws IOException {
        throw new IOException();
    }

    public void scan(Document d) throws IOException {
        throw new IOException();
    }
}

interface MultiFunctionDevice extends Printer, Scanner {

}

class MultiFunctionMachine implements MultiFunctionDevice {
    // compose this out of several modules
    private final Printer printer;
    private final Scanner scanner;

    public MultiFunctionMachine(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    public void print(Document d) throws IOException {
        printer.print(d);
    }

    public void scan(Document d) throws IOException {
        scanner.scan(d);
    }
}