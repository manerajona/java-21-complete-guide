package com.manerajona.java.programming.oop.innerclasses;

public class InnerClass {
    public static void main(String[] args) {
        GearBox mcLaren = new GearBox(6);
        mcLaren.addGear(1, 12.3);
        mcLaren.addGear(2, 15.3);
        mcLaren.addGear(3, 17.3);
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(100000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(200000));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(300000));
    }
}
