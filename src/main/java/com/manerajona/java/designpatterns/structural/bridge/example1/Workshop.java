package com.manerajona.java.designpatterns.structural.bridge.example1;

abstract class Workshop {
    abstract void work();
}

class Produce extends Workshop {
    @Override
    public void work() {
        System.out.print("Produced");
    }
}

class Assemble extends Workshop {
    @Override
    public void work() {
        System.out.print("And Assembled");
    }
}
