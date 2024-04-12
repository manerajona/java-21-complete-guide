package com.manerajona.java.programming.scope;

public final class FinalClass { // This class can't being instantiated cause is final
    public static final String CONSTANT = "this is a constant";

    // Anyone can instantiate this class either
    private FinalClass() {}

    // This can't being overwritten
    public final void someLogic() {
        System.out.println("Hello");
    }
}
