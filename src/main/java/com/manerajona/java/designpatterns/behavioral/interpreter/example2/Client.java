package com.manerajona.java.designpatterns.behavioral.interpreter.example2;

public class Client {

    static Expression maleExpression() {
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    static Expression marriedWomanExpression() {
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }

    public static void main(String[] args) {
        String johnIsMale = "John is male?";
        System.out.println(johnIsMale + " " + maleExpression().interpret(johnIsMale));

        String lucyIsMale = "Lucy is male?";
        System.out.println(lucyIsMale + " " + maleExpression().interpret(lucyIsMale));

        String julieIsAMarriedWomen = "Julie is a married women?";
        System.out.println(julieIsAMarriedWomen + " " + marriedWomanExpression().interpret(julieIsAMarriedWomen));
    }
}
