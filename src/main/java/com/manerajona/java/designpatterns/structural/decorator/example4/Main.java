package com.manerajona.java.designpatterns.structural.decorator.example4;

public class Main {
    public static void main(String[] args) {
        MagicString s = new MagicString("hello");
        System.out.printf("%s has %d vowels%n", s, s.getNumberOfVowels());
    }
}
