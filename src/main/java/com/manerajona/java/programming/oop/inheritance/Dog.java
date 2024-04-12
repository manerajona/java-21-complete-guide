package com.manerajona.java.programming.oop.inheritance;

public class Dog extends Animal {

    private int eye;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat) {
        super(name, 1, size, 1, weight);
        this.eye = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    @Override
    public void eat() {
        System.out.print("Animal is a dog and ");
        super.eat();
    }

    public void walk() {
        this.move(5);
    }

    public void run() {
        this.move(7);
    }

    private void moveLegs(int speed) {
        System.out.println("Dog is moving legs at "+speed);
    }

    @Override
    public void move(int speed) {
        moveLegs(speed);
        super.move(speed);
    }

    public int getEye() {
        return eye;
    }

    public void setEye(int eye) {
        this.eye = eye;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public int getTeeth() {
        return teeth;
    }

    public void setTeeth(int teeth) {
        this.teeth = teeth;
    }

    public String getCoat() {
        return coat;
    }

    public void setCoat(String coat) {
        this.coat = coat;
    }
}
