package com.manerajona.java.designpatterns.structural.flyweight.example4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class FormattedText {

    private final String plainText;
    private final boolean[] capitalize;

    public FormattedText(String plainText) {
        this.plainText = plainText;
        capitalize = new boolean[plainText.length()];
    }

    public void capitalize(int start, int end) {
        IntStream.rangeClosed(start, end).forEach(i -> capitalize[i] = true);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, plainText.length()).forEach(i -> {
            char c = plainText.charAt(i);
            sb.append(capitalize[i] ? Character.toUpperCase(c) : c);
        });
        return sb.toString();
    }
}

class BetterFormattedText {
    private static final String BOLD_FORMAT = "\033[0;1m";
    private static final String PLAINTEXT_FORMAT = "\033[0;0m";
    private final String plainText;
    private final List<TextRange> formatting = new ArrayList<>();

    public BetterFormattedText(String plainText) {
        this.plainText = plainText;
    }

    public TextRange getRange(int start, int end) {
        TextRange range = new TextRange(start, end);
        formatting.add(range);
        return range;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < plainText.length(); ++i) {
            char c = plainText.charAt(i);
            for (TextRange range : formatting) {
                if (range.covers(i)) {
                    if (range.capitalize) c = Character.toUpperCase(c);
                    else c = Character.toLowerCase(c);
                    if (range.bold) sb.append(BOLD_FORMAT);
                    else sb.append(PLAINTEXT_FORMAT);
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static class TextRange {
        private final int start;
        private final int end;
        private boolean capitalize;
        private boolean bold;

        public TextRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean covers(int position) {
            return position >= start && position <= end;
        }

        public void setCapitalize(boolean capitalize) {
            this.capitalize = capitalize;
        }

        public void setBold(boolean bold) {
            this.bold = bold;
        }
    }
}