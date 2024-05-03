package com.manerajona.java.designpatterns.structural.flyweight.example5;

public class Main {
    public static void main(String[] args) {
        Sentence sentence = new Sentence("Make America Great Again");
        sentence.getWord(0).setCapitalize(true);
        sentence.getWord(2).setCapitalize(true);
        System.out.println(sentence);
    }
}
