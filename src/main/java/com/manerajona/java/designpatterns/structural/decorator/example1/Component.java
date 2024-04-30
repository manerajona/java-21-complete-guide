package com.manerajona.java.designpatterns.structural.decorator.example1;

interface Component {
    void doJob();
}

class ConcreteComponent implements Component {

    @Override
    public void doJob() {
        System.out.println("I am from a Concrete Component - I am closed for modification");
    }
}