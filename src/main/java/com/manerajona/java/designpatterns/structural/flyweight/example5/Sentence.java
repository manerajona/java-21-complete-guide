package com.manerajona.java.designpatterns.structural.flyweight.example5;

import java.util.ArrayList;
import java.util.List;

class Sentence {

    private final List<WordToken> wordTokens = new ArrayList<>();

    public Sentence(String plainText) {
        for (String s : plainText.split(" ")) {
            WordToken wt = new WordToken(s, false);
            if (!wordTokens.contains(wt)) {
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

        private boolean capitalize;
        private final String word;

        public WordToken(String word, boolean capitalize) {
            this.capitalize = capitalize;
            this.word = word;
        }

        public void setCapitalize(boolean capitalize) {
            this.capitalize = capitalize;
        }
    }
}