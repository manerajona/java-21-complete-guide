package com.manerajona.java.designpatterns.structural.facade.example1;

class PopcornPopper {

    private final String description;

    public PopcornPopper(String description) {
        this.description = description;
    }

    public void on() {
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }

    public void pop() {
        System.out.println(description + " popping popcorn!");
    }


    public String toString() {
        return description;
    }
}
