package com.manerajona.java.designpatterns.creationals.builder.example5;

// builder inheritance with recursive generics
class Person {
    private String name;
    private String position;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

class PersonBuilder<P extends PersonBuilder<P>> {
    protected Person person = new Person();

    // critical to return SELF here
    public P withName(String name) {
        person.setName(name);
        return self();
    }

    protected P self() {
        // unchecked cast, but actually safe
        // proof: try sticking a non-PersonBuilder
        //        as SELF parameter; it won't work!
        return (P) this;
    }

    public Person build() {
        return person;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    public EmployeeBuilder worksAs(String position) {
        person.setPosition(position);
        return self();
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}