package com.manerajona.java.designpatterns.behavioral.observer.example2;

import java.util.ArrayList;
import java.util.List;

record PropertyChangedEventArgs<T>(T source, String propertyName, Object newValue) {
}

class Observable<T> {

    private final List<Observer<T>> observers = new ArrayList<>();

    public void subscribe(Observer<T> observer) {
        observers.add(observer);
    }

    protected void propertyChanged(T source, String propertyName, Object newValue) {
        observers.forEach(o -> o.handle(new PropertyChangedEventArgs<>(source, propertyName, newValue)));
    }
}
