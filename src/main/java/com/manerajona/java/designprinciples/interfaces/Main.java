package com.manerajona.java.designprinciples.interfaces;

public class Main {
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
