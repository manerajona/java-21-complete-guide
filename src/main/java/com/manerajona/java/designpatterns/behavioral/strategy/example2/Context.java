package com.manerajona.java.designpatterns.behavioral.strategy.example2;

import java.util.function.IntSupplier;

class Context {

    private Context() {
    }

    public static IntSupplier executeStrategy(Strategy strategy, int num1, int num2) {
        return () -> strategy.performOperation(num1, num2);
    }
}