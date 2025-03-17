package com.manerajona.java.designpatterns.behavioral.memento.example2;

public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Stash stash = new Stash();

        originator.setState("State #1");
        originator.save(stash);

        originator.setState("State #2");
        originator.save(stash);

        originator.setState("State #3");
        originator.save(stash);

        originator.setState("State #4");
        System.out.println("Current State: " + originator.getState());

        originator.undo(stash);
        System.out.println("Current State: " + originator.getState());

        originator.undo(stash);
        System.out.println("Current State: " + originator.getState());

        originator.undo(stash);
        System.out.println("Current State: " + originator.getState());

        originator.undo(stash);
        System.out.println("Current State: " + originator.getState());
    }
}