package com.manerajona.java.programming.oop.inheritance;

public class Fish extends Animal {

    private int eye;
    private int fin;

    public Fish(String name,int size, int weight, int eyes, int fins) {
        super(name, 1, size, 1, weight);
        this.eye = eyes;
        this.fin = fins;
    }

    private void rest() {
        System.out.println("Fish is resting");
    }

    private void moveFins(int speed) {
        System.out.println("Fish is moving fins at " +speed);
    }

    private void swinm(int speed) {
        super.move(speed);
        moveFins(speed);
    }

    public int getEye() {
        return eye;
    }

    public void setEye(int eye) {
        this.eye = eye;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }
}
