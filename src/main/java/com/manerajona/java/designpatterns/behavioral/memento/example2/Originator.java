package com.manerajona.java.designpatterns.behavioral.memento.example2;

class Originator {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void save(Stash stash) {
        stash.add(new Memento(state));
    }

    public void undo(Stash stash) {
        stash.pop().ifPresent(memento -> this.state = memento.change());
    }
}