package com.manerajona.java.designpatterns.behavioral.interpreter.example3;

record Token(Type type, String term) {
    public enum Type {
        INTEGER, PLUS, MINUS, LPAREN, RPAREN
    }
}