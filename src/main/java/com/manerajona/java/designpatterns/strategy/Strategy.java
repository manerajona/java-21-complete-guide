package com.manerajona.java.designpatterns.strategy;

import java.util.List;
import java.util.function.Supplier;

class DynamicStrategy {
    public static void main(String[] args) {
        TextProcessor<MarkdownListStrategy> tp = new TextProcessor<>(MarkdownListStrategy::new);
        tp.appendList(List.of("liberte", "egalite", "fraternite"));
        System.out.println(tp);

        TextProcessor<HtmlListStrategy> tp2 = new TextProcessor<>(HtmlListStrategy::new);
        tp2.appendList(List.of("inheritance", "encapsulation", "polymorphism"));
        System.out.println(tp2);
    }
}

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

// STATIC IMPLEMENTATION (can't switch strategy at run time)
class TextProcessor<LS extends ListStrategy> {
    private StringBuilder sb = new StringBuilder();
    private LS listStrategy;

    public TextProcessor(Supplier<? extends LS> supplier) {
        listStrategy = supplier.get(); // the way to instantiate Generics (listStrategy = new LS() IS NOT ALLOWED!)
    }

    // the skeleton algorithm is here
    public void appendList(List<String> items) {
        listStrategy.start(sb);
        items.forEach(item -> listStrategy.addListItem(sb, item));
        listStrategy.end(sb);
    }

    public void clear() {
        sb.setLength(0);
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}

// DYNAMIC IMPLEMENTATION (switch strategy at run time)
/*
class TextProcessor {
    private StringBuilder sb = new StringBuilder();
    // cannot do this
    // private LS listStrategy = new LS();
    private ListStrategy listStrategy;

    enum OutputFormat {
        MARKDOWN, HTML
    }

    public TextProcessor(OutputFormat output) {
        setOutputFormat(output);
    }

    private void setOutputFormat(OutputFormat output) {
        switch (output) {
            case HTML:
                listStrategy = new MarkdownListStrategy();
                break;
            case MARKDOWN:
                listStrategy = new HtmlListStrategy();
                break;
        }
    }

    // the skeleton algorithm is here
    public void appendList(List<String> items) {
        listStrategy.start(sb);
        items.forEach(item -> listStrategy.addListItem(sb, item));
        listStrategy.end(sb);
    }

    public void clear() {
        sb.setLength(0);
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
*/
