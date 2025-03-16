package com.manerajona.java.designpatterns.behavioral.interpreter.example3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Client {

    public static void main(String[] args) {
        String expression = "(100+20)-(120-(1+3))";

        List<Token> tokens = lex(expression);
        System.out.println(tokens.stream().map(Token::toString).collect(Collectors.joining("\n")));

        Term parsed = Parser.parse(tokens);
        System.out.println(expression + " = " + parsed.eval());
    }

    static List<Token> lex(String expression) {
        List<Token> tokens = new ArrayList<>();

        int index = 0;
        while (index < expression.length()) {

            char ch = expression.charAt(index);

            // Skip whitespaces
            if (Character.isWhitespace(ch)) {
                index++;
                continue;
            }

            switch (ch) {
                case '+' -> {
                    tokens.add(new Token(Token.Type.PLUS, "+"));
                    index++;
                }
                case '-' -> {
                    tokens.add(new Token(Token.Type.MINUS, "-"));
                    index++;
                }
                case '(' -> {
                    tokens.add(new Token(Token.Type.LPAREN, "("));
                    index++;
                }
                case ')' -> {
                    tokens.add(new Token(Token.Type.RPAREN, ")"));
                    index++;
                }
                default -> {
                    if (Character.isDigit(ch)) {
                        int start = index;
                        while (index < expression.length() && Character.isDigit(expression.charAt(index))) {
                            index++;
                        }
                        String numStr = expression.substring(start, index);
                        tokens.add(new Token(Token.Type.INTEGER, numStr));
                    } else {
                        throw new IllegalArgumentException("Unexpected character: " + ch);
                    }
                }
            }
        }
        return tokens;
    }
}

