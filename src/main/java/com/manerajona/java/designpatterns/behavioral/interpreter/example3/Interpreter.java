package com.manerajona.java.designpatterns.behavioral.interpreter.example3;

import java.util.List;

interface Term {
    int eval();
}

class Parser {

    private final List<Token> tokens;
    private int currentPosition;

    private Parser(List<Token> tokens) {
        this.tokens = tokens;
        this.currentPosition = 0;
    }

    public static Term parse(List<Token> tokens) {
        return new Parser(tokens).parseExpression();
    }

    private Term parseExpression() {
        Term left = parseTerm();
        while (currentPosition < tokens.size() &&
                (tokens.get(currentPosition).type() == Token.Type.PLUS ||
                        tokens.get(currentPosition).type() == Token.Type.MINUS)) {
            Token op = tokens.get(currentPosition++);
            BinaryOperation.Type type = op.type() == Token.Type.PLUS
                    ? BinaryOperation.Type.ADDITION
                    : BinaryOperation.Type.SUBTRACTION;
            Term right = parseTerm();
            left = new BinaryOperation(type, left, right); // Build left-associative operations.
        }
        return left;
    }

    // Parse a term: an INTEGER or a parenthesized expression
    private Term parseTerm() {
        Token token = tokens.get(currentPosition++);
        return switch (token.type()) {
            case INTEGER -> new Int(token.term());
            case LPAREN -> {
                Term expr = parseExpression();
                if (currentPosition >= tokens.size() || tokens.get(currentPosition).type() != Token.Type.RPAREN) {
                    throw new IllegalStateException("Missing closing parenthesis");
                }
                currentPosition++; // Skip the RPAREN
                yield expr;
            }
            default -> throw new IllegalStateException("Unexpected token: " + token.type());
        };
    }
}

class Int implements Term {

    private final int value;

    public Int(String value) {
        this.value = Integer.parseInt(value);
    }

    public int eval() {
        return value;
    }
}

class BinaryOperation implements Term {

    private final Type type;
    private final Term left;
    private final Term right;

    public BinaryOperation(Type type, Term left, Term right) {
        this.type = type;
        this.left = left;
        this.right = right;
    }

    public int eval() {
        return switch (type) {
            case ADDITION -> left.eval() + right.eval();
            case SUBTRACTION -> left.eval() - right.eval();
        };
    }

    public enum Type {
        ADDITION, SUBTRACTION
    }
}