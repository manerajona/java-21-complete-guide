package com.manerajona.java.designpatterns.behavioral.mediator.example3;

class FootballObserver {

    public FootballObserver(ObservableMatch match) {
        match.subscribe(event -> System.out.printf("%s scored %d goals!%n", event.team(), event.goals()));
    }
}
