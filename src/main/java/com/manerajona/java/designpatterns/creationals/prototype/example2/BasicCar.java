package com.manerajona.java.designpatterns.creationals.prototype.example2;

import java.util.Random;

abstract class BasicCar implements Cloneable {
    private static final Random RANDOM = new Random();
    protected String modelName;
    private int price;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public static int generatePrice() {
        int price;
        price = RANDOM.nextInt(100000);
        return price;
    }

    public int price() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public BasicCar clone() {
        BasicCar clone = null;
        try {
            clone = (BasicCar) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}

class Ford extends BasicCar implements Cloneable {

    public Ford(String m) {
        modelName = m;
    }

    @Override
    public Ford clone() {
        return (Ford) super.clone();
    }
}

class Nano extends BasicCar implements Cloneable {

    public Nano(String m) {
        modelName = m;
    }

    @Override
    public Nano clone() {
        return (Nano) super.clone();
    }
}