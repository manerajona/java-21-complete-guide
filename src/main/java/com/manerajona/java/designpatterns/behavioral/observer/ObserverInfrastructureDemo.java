package com.manerajona.java.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class ObserverInfrastructureDemo implements Observer<Person> {

    public ObserverInfrastructureDemo() {
        Person person = new Person();
        person.subscribe(this);
        IntStream.range(20, 25).forEach(person::setAge);
    }

    public static void main(String[] args) {
        new ObserverInfrastructureDemo();
    }

    @Override
    public void handle(PropertyChangedEventArgs<Person> args) {
        System.out.printf("Person's %s has been changed to %s%n", args.propertyName, args.newValue);
    }
}


class PropertyChangedEventArgs<T> {
    public T source;
    public String propertyName;
    public Object newValue;

    public PropertyChangedEventArgs(T source, String propertyName, Object newValue) {
        this.source = source;
        this.propertyName = propertyName;
        this.newValue = newValue;
    }
}

// observes objects of type T
interface Observer<T> {
    void handle(PropertyChangedEventArgs<T> args);
}

// can be observed
class Observable<T> {

    private List<Observer<T>> observers = new ArrayList<>();

    public void subscribe(Observer<T> observer) {
        observers.add(observer);
    }

    protected void propertyChanged(T source, String propertyName, Object newValue) {
        for (Observer<T> o : observers) {
            o.handle(new PropertyChangedEventArgs<>(source, propertyName, newValue));
        }
    }
}

class Person extends Observable<Person> {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (this.age == age) return;
        this.age = age;
        // HERE the magic happens!
        propertyChanged(this, "age", age);
    }
}
