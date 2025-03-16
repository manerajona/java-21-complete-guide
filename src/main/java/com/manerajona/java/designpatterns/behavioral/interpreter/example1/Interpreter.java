package com.manerajona.java.designpatterns.behavioral.interpreter.example1;

class Interpreter {

    public String toBinary(String exp) {
        return Integer.toBinaryString(
                Integer.parseInt(exp)
        );
    }

    public String toHexadecimal(String exp) {
        return Integer.toHexString(
                Integer.parseInt(exp)
        );
    }
}
