package com.manerajona.java.designpatterns.structural.flyweight.example2;

interface Player {
    // extrinsic data
    void assignWeapon(String weapon);

    void mission();
}

class Terrorist implements Player {
    // intrinsic attribute
    private final String task;

    // extrinsic attribute
    private String weapon;

    public Terrorist() {
        task = "Plant a bomb";
    }

    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void mission() {
        System.out.println("Terrorist with weapon " + weapon + " : Task is " + task);
    }
}

class CounterTerrorist implements Player {
    // intrinsic attribute
    private final String task;

    // extrinsic attribute
    private String weapon;

    public CounterTerrorist() {
        task = "Diffuse a bomb";
    }

    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void mission() {
        System.out.println("Counter Terrorist with weapon " + weapon + " : Task is " + task);
    }
}
