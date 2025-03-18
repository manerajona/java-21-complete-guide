package com.manerajona.java.designpatterns.behavioral.strategy.example3;

import java.util.List;

class Client {
    public static void main(String[] args) {
        final List<String> listOfValues = List.of("liberte", "egalite", "fraternite");

        TextProcessor<MarkdownListStrategy> mdProcessor = new TextProcessor<>(MarkdownListStrategy::new);
        mdProcessor.appendList(listOfValues);
        System.out.println(mdProcessor);

        TextProcessor<HtmlListStrategy> htmlProcessor = new TextProcessor<>(HtmlListStrategy::new);
        htmlProcessor.appendList(listOfValues);
        System.out.println(htmlProcessor);
    }
}
