package com.manerajona.java.designpatterns.memento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Token {
    public int value = 0;

    public Token(int value) {
        this.value = value;
    }
}

class Snapshot {
    public List<Token> tokens = new ArrayList<>();
}

class TokenMachine {
    public List<Token> tokens = new ArrayList<>();

    public Snapshot addToken(int value) {
        return addToken(new Token(value));
    }

    public Snapshot addToken(Token token) {
        tokens.add(token);

        Snapshot m = new Snapshot();
        m.tokens = tokens.stream()
                .map(t -> new Token(t.value))
                .collect(Collectors.toList());
        return m;
    }

    public void revert(Snapshot m) {
        tokens = m.tokens.stream()
                .map(t -> new Token(t.value))
                .collect(Collectors.toList());
    }
}