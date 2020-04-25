package com.manerajona.java.designpatterns.proxy;

class Persona {
    private int age;

    public Persona(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String drink() {
        return "drinking";
    }

    public String drive() {
        return "driving";
    }

    public String drinkAndDrive() {
        return "driving while drunk";
    }
}

class ResponsiblePersona extends Persona {

    public ResponsiblePersona(Persona person) {
        super(person.getAge());
    }

    public ResponsiblePersona(int age) {
        super(age);
    }

    @Override
    public String drink() {
        return (getAge() > 18) ? super.drink() : "too young";
    }

    @Override
    public String drive() {
        return (getAge() > 16) ? super.drive() : "too young";
    }

    @Override
    public String drinkAndDrive() {
        return "dead";
    }
}