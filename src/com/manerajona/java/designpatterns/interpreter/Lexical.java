package com.manerajona.java.designpatterns.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lexical {
    public static List<Token> lex(String in) {
        ArrayList<Token> result = new ArrayList<>();
        for (int i = 0; i < in.length(); ++i) {
            switch (in.charAt(i)) {
                case '+':
                    result.add(new Token(Token.Type.PLUS, "+"));
                    break;
                case '-':
                    result.add(new Token(Token.Type.MINUS, "-"));
                    break;
                case '(':
                    result.add(new Token(Token.Type.LPAREN, "("));
                    break;
                case ')':
                    result.add(new Token(Token.Type.RPAREN, ")"));
                    break;
                default:
                    StringBuilder sb = new StringBuilder("" + in.charAt(i));
                    for (int j = i + 1; j < in.length(); ++j) {
                        if (Character.isDigit(in.charAt(j))) {
                            sb.append(in.charAt(j));
                            ++i;
                        } else {
                            result.add(new Token(Token.Type.INTEGER, sb.toString()));
                            break;
                        }
                    }
                    break;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        String input = "(100+20)-(120-1)";
        List<Token> tokens = lex(input);
        System.out.println(
                tokens.stream().map(Token::toString).collect(Collectors.joining("\n"))
        );
        Element parsed = Parser.parse(tokens);
        System.out.println(input + " = " + parsed.eval());

    }
}

class Token {
    public enum Type {
        INTEGER, PLUS, MINUS, LPAREN, RPAREN
    }

    public Type type;
    public String text;

    public Token(Type type, String text) {
        this.type = type;
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("type=%s, text='%s'", type, text);
    }
}
