package com.manerajona.java.programming.oop.innerclasses;

import java.util.ArrayList;

public class GearBox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private boolean clutchsIsIn;

    public GearBox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<>();
        Gear neutral = new Gear(0,0.0);
        this.gears.add(neutral);
    }

    public void operateClutch(boolean in) {
        this.clutchsIsIn = in;
    }

    public void addGear(int number, double ratio){
        if(number>0 && number<=maxGears) {
            this.gears.add(new Gear(number, ratio));
        }
    }

    public void changeGear(int newGear) {
        if(newGear>=0 && newGear<this.gears.size() && this.clutchsIsIn) {
            this.currentGear = newGear;
            System.out.printf("Gear %d selected\n", newGear);
        } else {
            this.currentGear = 0;
            System.out.println("Grind!");
        }
    }

    public double wheelSpeed (int revs) {
        if(clutchsIsIn) {
            return 0.0;
        }
        return (revs * gears.get(currentGear).getRatio());
    }

    private class Gear {
        private int gearNumber;
        private double ratio;

        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        public double getRatio() {
            return ratio;
        }
    }
}
