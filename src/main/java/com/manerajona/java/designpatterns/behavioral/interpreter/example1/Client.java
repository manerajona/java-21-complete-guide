package com.manerajona.java.designpatterns.behavioral.interpreter.example1;

public class Client {

    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter();

        var binExp = new IntToBinExpression("12", interpreter);
        var hexExp = new IntToHexExpression("12", interpreter);

        System.out.println(binExp.originalExpression + " in binary eq " + binExp.interpret());
        System.out.println(hexExp.originalExpression + " in hexadecimal eq " + hexExp.interpret());
    }
}
