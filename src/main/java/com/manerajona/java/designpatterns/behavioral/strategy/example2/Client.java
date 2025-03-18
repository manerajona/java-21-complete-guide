package com.manerajona.java.designpatterns.behavioral.strategy.example2;

import java.util.function.IntSupplier;

public class Client {
    public static void main(String[] args) {
        IntSupplier addResult = Context.executeStrategy(new OperationAdd(), 10, 5);
        IntSupplier subtractResult = Context.executeStrategy(new OperationSubtract(), 10, 5);
        IntSupplier multiplyResult = Context.executeStrategy(new OperationMultiply(), 10, 5);

        System.out.println("10 + 5 = " + addResult.getAsInt());
        System.out.println("10 - 5 = " + subtractResult.getAsInt());
        System.out.println("10 * 5 = " + multiplyResult.getAsInt());
    }
}
