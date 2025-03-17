package com.manerajona.java.designpatterns.behavioral.mediator.example3;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;

import java.util.ArrayList;
import java.util.List;

record ScoreEvent(String team, int goals) {

}

class ObservableMatch extends Observable<ScoreEvent> {
    private final List<Observer<? super ScoreEvent>> events = new ArrayList<>();

    @Override
    protected void subscribeActual(@NonNull Observer<? super ScoreEvent> score) {
        events.add(score);
    }

    public void publish(ScoreEvent e) {
        events.forEach(o -> o.onNext(e));
    }
}