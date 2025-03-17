package com.manerajona.java.designpatterns.behavioral.memento.example2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

class Stash {
    private final Deque<Memento> changes = new ArrayDeque<>();

    public void add(Memento snapshot) {
        changes.push(snapshot);
    }

    public Optional<Memento> pop() {
        return !changes.isEmpty() ? Optional.of(changes.pop()) : Optional.empty();
    }
}