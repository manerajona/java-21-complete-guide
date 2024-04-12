package com.manerajona.java.designpatterns.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class FormattedTextFW {
    public static void main(String[] args) {
        FormattedText ft = new FormattedText("This is a brave new world");
        ft.capitalize(10, 15);
        System.out.println(ft);

        BetterFormattedText bft = new BetterFormattedText("Make America Great Again");
        bft.getRange(13, 18).capitalize = true;
        bft.getRange(0, 11).bold = true;
        System.out.println(bft);
    }
}

class FormattedText {
    private String plainText;
    private boolean[] capitalize;

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
    public static final String BOLD = "\033[0;1m";
    public static final String PLAINTEXT = "\033[0;0m";
    private String plainText;
    private List<TextRange> formatting = new ArrayList<>();

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
                    if (range.bold) sb.append(BOLD);
                    else sb.append(PLAINTEXT);
                    if (range.italic) ;//TODO
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static class TextRange {
        public int start, end;
        public boolean capitalize, bold, italic;

        public TextRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean covers(int position) {
            return position >= start && position <= end;
        }
    }
}