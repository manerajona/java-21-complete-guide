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

public class Computer {
    private DisplayModule dm;

    public void setDisplayModule(DisplayModule dm) {
        this.dm = dm;
    }

    public void display() {
        dm.display();
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        DisplayModule monitor = new Monitor();
        DisplayModule project = new Projector();

        computer.setDisplayModule(monitor);
        computer.display();
        computer.setDisplayModule(project);
        computer.display();
    }
}