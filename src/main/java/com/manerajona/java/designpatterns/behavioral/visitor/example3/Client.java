package com.manerajona.java.designpatterns.behavioral.visitor.example3;

public class Client {
    public static void main(String[] args) {
        // 1+(2+3)
        AdditionExpression additionExpression = new AdditionExpression(
                new DoubleExpression(1),
                new AdditionExpression(
                        new DoubleExpression(2),
                        new DoubleExpression(3)
                ));

        var expressionPrinter = ExpressionPrinter.createExpressionPrinter()
                .visit(additionExpression)
                .toString();
        System.out.println(expressionPrinter);

        var result = ExpressionCalculator.createExpressionCalculator()
                .visit(additionExpression)
                .toString();
        System.out.printf("%s = %s%n", expressionPrinter, result);

        result = ExpressionPrinter.createExpressionPrinter()
                .visit(new DoubleExpression(6.0))
                .toString();
        System.out.printf("result = %s%n", result);
    }
}
