package com.manerajona.java.designpatterns.behavioral.observer.example2;

import java.util.stream.IntStream;

interface Observer<T> {
    void handle(PropertyChangedEventArgs<T> args);
}

class PersonObserver implements Observer<Person> {

    private final Person person = new Person("Tim", 9, 150);

    PersonObserver() {
        // Subscribe to observable
        person.subscribe(this);
        // Change person's age
        IntStream.rangeClosed(1, 5)
                .forEach(years -> person.setAge(person.getAge() + years));
        // Change person's height
        IntStream.iterate(5, centimeters -> centimeters < 20, centimeters -> centimeters + 5)
                .forEach(centimeters -> person.setHeight(person.getHeight() + centimeters));
    }

    public static void main(String[] args) {
        new PersonObserver();
    }

    @Override
    public void handle(PropertyChangedEventArgs<Person> args) {
        System.out.printf("%s's %s has been changed to %s%n", person.getName(), args.propertyName(), args.newValue());
    }
}

