package com.manerajona.java.designpatterns.behavioral.visitor.example3;

interface Expression {
    void accept(ExpressionVisitor visitor);
}

record DoubleExpression(double value) implements Expression {
    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }
}

record AdditionExpression(Expression left, Expression right) implements Expression {
    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }
}
