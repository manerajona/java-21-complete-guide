package com.manerajona.java.designprinciples.interfaces;

interface DisplayModule {
    void display();
}

class Monitor implements DisplayModule {
    public void display() {
        System.out.println("Display through Monitor");
    }
}

class Projector implements DisplayModule {
    public void display() {
        System.out.println("Display through projector");
    }
}

class Computer {
    private DisplayModule dm;

    public void setDisplayModule(DisplayModule dm) {
        this.dm = dm;
    }

    public void display() {
        dm.display();
    }
}