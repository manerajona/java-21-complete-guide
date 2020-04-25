package com.manerajona.java.designpatterns.flyweight;

import java.util.ArrayList;
import java.util.List;

class FWChallenge {
    public static void main(String[] args) {
        Sentence sentence = new Sentence("Make America Great Again");
        sentence.getWord(0).capitalize = true;
        sentence.getWord(2).capitalize = true;
        System.out.println(sentence);
    }
}

class Sentence {
    private List<WordToken> wordTokens = new ArrayList<>();

    public Sentence(String plainText) {
        for (String s : plainText.split(" ")) {
            WordToken wt = new WordToken(s, false);
            if (wordTokens.indexOf(wt) == -1) {
                wordTokens.add(wt);
            }
        }
    }

    public WordToken getWord(int index) {
        return wordTokens.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (WordToken wt : wordTokens) {
            sb.append(wt.capitalize ? wt.word.toUpperCase() : wt.word);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    static class WordToken {
        public boolean capitalize;
        public String word;

        public WordToken(String word, boolean capitalize) {
            this.capitalize = capitalize;
            this.word = word;
        }
    }
}