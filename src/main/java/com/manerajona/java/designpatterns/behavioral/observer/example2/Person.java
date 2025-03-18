package com.manerajona.java.designpatterns.behavioral.observer.example2;

class Person extends Observable<Person> {
    private final String name;
    private int age;
    private int height;

    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (this.age == age) {
            return;
        }
        this.age = age;
        propertyChanged(this, "age", age);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (this.height == height) {
            return;
        }
        this.height = height;
        propertyChanged(this, "height", height);
    }
}
