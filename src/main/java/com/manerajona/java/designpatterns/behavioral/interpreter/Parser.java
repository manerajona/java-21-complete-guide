package com.manerajona.java.designpatterns.behavioral.interpreter;

import java.util.List;
import java.util.stream.Collectors;

class Parser {
    public static Element parse(List<Token> tokens) {
        BinaryOperation result = new BinaryOperation();
        boolean haveLHS = false;

        for (int i = 0; i < tokens.size(); ++i) {
            Token t = tokens.get(i);

            switch (t.type) {
                case INTEGER:
                    Integer integer = new Integer(java.lang.Integer.parseInt(t.text));
                    if (haveLHS) {
                        result.right = integer;
                    } else {
                        result.left = integer;
                        haveLHS = true;
                    }
                    break;
                case PLUS:
                    result.type = BinaryOperation.Type.ADDITION;
                    break;
                case MINUS:
                    result.type = BinaryOperation.Type.SUBSTRACTION;
                    break;
                case LPAREN:
                    int j = i;
                    for (; j < tokens.size(); ++j) {
                        if (tokens.get(j).type == Token.Type.RPAREN)
                            break;
                    }

                    List<Token> subexpression =
                            tokens.stream()
                                    .skip(i + 1)
                                    .limit(j - i - 1)
                                    .collect(Collectors.toList());

                    Element element = parse(subexpression);

                    if (haveLHS) {
                        result.right = element;
                    } else {
                        result.left = element;
                        haveLHS = true;
                    }
                    i = j;
                    break;
            }
        }
        return result;
    }

}

interface Element {
    int eval();
}

class Integer implements Element {

    public Integer(int value) {
        this.value = value;
    }

    private int value;

    public int eval() {
        return value;
    }
}

class BinaryOperation implements Element {

    public enum Type {
        ADDITION, SUBSTRACTION
    }

    public Type type;
    public Element left, right;

    public BinaryOperation() {
    }

    public int eval() {
        switch (type) {
            case ADDITION:
                return left.eval() + right.eval();
            case SUBSTRACTION:
                return left.eval() - right.eval();
            default:
                return 0;
        }
    }
}