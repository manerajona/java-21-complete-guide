package com.manerajona.java.designpatterns.behavioral.template.example1;

abstract class HouseTemplate {

    // template method, final so subclasses cannot override it
    public final HouseTemplate buildHouse() {
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        System.out.println("House is built");
        return this;
    }

    // default implementation, hook method
    private void buildWindows() {
        System.out.println("Building Glass Windows");
    }

    //methods to be implemented by subclasses
    public abstract void buildWalls();

    public abstract void buildPillars();

    private void buildFoundation() {
        System.out.println("Building foundation with cement, iron rods and sand");
    }

    @Override
    public String toString() {
        return "HouseTemplate{" + this.getClass().getSimpleName() + "}";
    }
}

class WoodenHouse extends HouseTemplate {
    @Override
    public void buildWalls() {
        System.out.println("Building Wooden Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Pillars with Wood coating");
    }
}

class GlassHouse extends HouseTemplate {
    @Override
    public void buildWalls() {
        System.out.println("Building Glass Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Pillars with glass coating");
    }
}