package com.manerajona.java.designpatterns.behavioral.visitor.example3;

interface ExpressionVisitor {
    ExpressionVisitor visit(DoubleExpression e);

    ExpressionVisitor visit(AdditionExpression e);
}

class ExpressionPrinter implements ExpressionVisitor {
    private final StringBuilder sb = new StringBuilder();

    private ExpressionPrinter() {
    }

    static ExpressionPrinter createExpressionPrinter() {
        return new ExpressionPrinter();
    }

    @Override
    public ExpressionVisitor visit(DoubleExpression expression) {
        sb.append(expression.value());
        return this;
    }

    @Override
    public ExpressionVisitor visit(AdditionExpression expression) {
        sb.append("(");
        expression.left().accept(this);
        sb.append("+");
        expression.right().accept(this);
        sb.append(")");
        return this;
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}

class ExpressionCalculator implements ExpressionVisitor {
    private double result;

    private ExpressionCalculator() {
    }

    static ExpressionCalculator createExpressionCalculator() {
        return new ExpressionCalculator();
    }

    @Override
    public ExpressionVisitor visit(DoubleExpression expression) {
        this.result = expression.value();
        return this;
    }

    @Override
    public ExpressionVisitor visit(AdditionExpression expression) {
        expression.left().accept(this);
        double a = result;
        expression.right().accept(this);
        double b = result;
        result = a + b;
        return this;
    }

    @Override
    public String toString() {
        return Double.toString(result);
    }
}