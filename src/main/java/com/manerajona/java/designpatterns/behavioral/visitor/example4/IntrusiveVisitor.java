package com.manerajona.java.designpatterns.behavioral.visitor.example4;

interface Expression {
    void print(StringBuilder sb);
}

record DoubleExpression(double value) implements Expression {
    @Override
    public void print(StringBuilder sb) {
        sb.append(value);
    }
}

record AdditionExpression(Expression left, Expression right) implements Expression {
    @Override
    public void print(StringBuilder sb) {
        sb.append("(");
        left.print(sb);
        sb.append("+");
        right.print(sb);
        sb.append(")");
    }
}
