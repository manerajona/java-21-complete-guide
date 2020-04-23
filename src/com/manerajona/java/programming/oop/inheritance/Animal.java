package com.manerajona.java.programming.oop.inheritance;

public class Animal {
    private String name;
    private int brain;
    private int size;
    private int body;
    private int weight;

    public Animal(String name, int brain, int size, int body, int weight) {
        this.name = name;
        this.brain = brain;
        this.size = size;
        this.body = body;
        this.weight = weight;
    }

    public void eat() {
        System.out.println("Animal is eating");
    }

    public void move(int speed) {
        System.out.println("Animal is moving at " + speed);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBrain() {
        return brain;
    }

    public void setBrain(int brain) {
        this.brain = brain;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
