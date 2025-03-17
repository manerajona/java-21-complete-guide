package com.manerajona.java.designpatterns.behavioral.mediator.example3;

public class Client {
    public static void main(String[] args) {
        ObservableMatch match = new ObservableMatch();

        FootballTeam boca = new FootballTeam("Boca", match);
        FootballTeam river = new FootballTeam("River", match);

        new FootballObserver(match);

        boca.score();
        river.score();
        boca.score();
    }
}