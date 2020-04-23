package com.manerajona.java.programming.scope;

public class StaticClass {
    private static int instanceCounter = 0;
    public final int instanceNumber;
    private String name;

    private static final int C1 ;
    private static final int C2;
    private static final int C3;

    static {
        C1 = 1;
        C2 = 2;
        C3 = 3;
        System.out.println("static block called");
    }

    public static StaticClass getInstance() {
        return new StaticClass("Instance " + instanceCounter);
    }

    private StaticClass(String name) {
        this.name = name;
        instanceCounter++;
        instanceNumber = instanceCounter;
    }

    public static int getInstanceCounter() {
        return instanceCounter;
    }

    public String getName() {
        return name;
    }
}
