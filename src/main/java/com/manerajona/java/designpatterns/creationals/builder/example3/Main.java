package com.manerajona.java.designpatterns.creationals.builder.example3;

public class Main {
    public static void main(String[] args) {
        HtmlBuilder builder = new HtmlBuilder("ul");

        // ordinary non-fluent builder
        builder.addChild("li", "hello");
        builder.addChild("li", "world");
        System.out.println(builder);

        // fluent builder
        builder
                .clear()
                .addChildFluent("li", "hello")
                .addChildFluent("li", "world");
        System.out.println(builder);
    }
}
