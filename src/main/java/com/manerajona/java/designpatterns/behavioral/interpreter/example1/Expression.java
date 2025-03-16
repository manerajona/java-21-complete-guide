package com.manerajona.java.designpatterns.behavioral.interpreter.example1;

abstract class Expression {
    protected final String originalExpression;
    protected final Interpreter interpreter;

    Expression(String original, Interpreter interpreter) {
        this.originalExpression = original;
        this.interpreter = interpreter;
    }

    abstract String interpret();
}

class IntToBinExpression extends Expression {

    public IntToBinExpression(String intExp, Interpreter interpreter) {
        super(intExp, interpreter);
    }

    @Override
    public String interpret() {
        return interpreter.toBinary(originalExpression);
    }
}

class IntToHexExpression extends Expression {

    public IntToHexExpression(String intExp, Interpreter interpreter) {
        super(intExp, interpreter);
    }

    @Override
    public String interpret() {
        return interpreter.toHexadecimal(originalExpression);
    }
}
