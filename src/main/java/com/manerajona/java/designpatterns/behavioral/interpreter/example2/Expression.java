package com.manerajona.java.designpatterns.behavioral.interpreter.example2;

interface Expression {
    boolean interpret(String sentence);
}

class AndExpression implements Expression {
    private final Expression expr1;
    private final Expression expr2;

    public AndExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String sentence) {
        return expr1.interpret(sentence) && expr2.interpret(sentence);
    }
}

class OrExpression implements Expression {
    private final Expression expr1;
    private final Expression expr2;

    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String sentence) {
        return expr1.interpret(sentence) || expr2.interpret(sentence);
    }
}

class TerminalExpression implements Expression {

    private final String expression;

    public TerminalExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public boolean interpret(String sentence) {
        return sentence.toLowerCase().contains(expression.toLowerCase());
    }
}