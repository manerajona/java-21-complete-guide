package com.manerajona.java.designpatterns.behavioral.chainofresponsibility.example3;

import java.util.ArrayList;
import java.util.List;

class Contest {

    private final String name;
    private final List<AbstractPlayer> players = new ArrayList<>();

    public Contest(String name) {
        this.name = name;
    }

    public void addPlayer(AbstractPlayer player) {
        players.add(player);
    }

    public List<AbstractPlayer> players() {
        return List.copyOf(players);
    }

    @Override
    public String toString() {
        return "Contest{name=%s}".formatted(name);
    }
}
