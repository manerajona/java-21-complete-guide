package com.manerajona.java.designprinciples.solid.interfacesegregation.example2;

class Document {
}

/*
    ANTI-PATTERN WAY
 */

interface Machine {
    void print(Document d);

    void fax(Document d) throws Exception;

    void scan(Document d) throws Exception;
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

    public void fax(Document d) throws Exception {
        throw new Exception();
    }

    public void scan(Document d) throws Exception {
        throw new Exception();
    }
}

/*
    ISP WAY
 */

interface Printer {
    void Print(Document d) throws Exception;
}

interface IScanner {
    void Scan(Document d) throws Exception;
}

class JustAPrinter implements Printer {
    public void Print(Document d) {

    }
}

class Photocopier implements Printer, IScanner {
    public void Print(Document d) throws Exception {
        throw new Exception();
    }

    public void Scan(Document d) throws Exception {
        throw new Exception();
    }
}

interface MultiFunctionDevice extends Printer, IScanner //
{

}

class MultiFunctionMachine implements MultiFunctionDevice {
    // compose this out of several modules
    private final Printer printer;
    private final IScanner scanner;

    public MultiFunctionMachine(Printer printer, IScanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    public void Print(Document d) throws Exception {
        printer.Print(d);
    }

    public void Scan(Document d) throws Exception {
        scanner.Scan(d);
    }
}