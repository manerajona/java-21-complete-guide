package com.manerajona.java.designpatterns.behavioral.strategy.example3;

interface ListStrategy {

    default void start(StringBuilder sb) {
    }

    default void end(StringBuilder sb) {
    }

    void addListItem(StringBuilder stringBuilder, String item);
}

class MarkdownListStrategy implements ListStrategy {
    @Override
    public void addListItem(StringBuilder stringBuilder, String item) {
        stringBuilder
                .append(" * ")
                .append(item)
                .append(System.lineSeparator());
    }
}

class HtmlListStrategy implements ListStrategy {
    @Override
    public void start(StringBuilder stringBuilder) {
        stringBuilder
                .append("<ul>")
                .append(System.lineSeparator());
    }

    @Override
    public void addListItem(StringBuilder stringBuilder, String item) {
        stringBuilder
                .append("  <li>")
                .append(item)
                .append("</li>")
                .append(System.lineSeparator());
    }

    @Override
    public void end(StringBuilder stringBuilder) {
        stringBuilder
                .append("</ul>")
                .append(System.lineSeparator());
    }
}

