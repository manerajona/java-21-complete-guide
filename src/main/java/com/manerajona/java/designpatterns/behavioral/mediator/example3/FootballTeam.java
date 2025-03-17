package com.manerajona.java.designpatterns.behavioral.mediator.example3;

class FootballTeam {
    private final String name;
    private final ObservableMatch match;
    private int goalsScored = 0;

    public FootballTeam(String name, ObservableMatch match) {
        this.name = name;
        this.match = match;
    }

    public void score() {
        this.goalsScored++;
        match.publish(new ScoreEvent(name, goalsScored));
    }
}
