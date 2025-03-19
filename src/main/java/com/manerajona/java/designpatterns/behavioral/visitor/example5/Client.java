package com.manerajona.java.designpatterns.behavioral.visitor.example5;

public class Client {
    public static void main(String[] args) {
        AdditionExpressionAcyclic expression = new AdditionExpressionAcyclic(
                new DoubleExpressionAcyclic(1),
                new AdditionExpressionAcyclic(
                        new DoubleExpressionAcyclic(2),
                        new DoubleExpressionAcyclic(3)
                )
        );
        ExpressionAcyclicPrinter expressionAcyclicPrinter = new ExpressionAcyclicPrinter();
        expressionAcyclicPrinter.visit(expression);
        System.out.println(expressionAcyclicPrinter);
    }
}
