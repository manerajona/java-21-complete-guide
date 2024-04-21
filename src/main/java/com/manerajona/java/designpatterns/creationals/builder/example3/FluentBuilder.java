package com.manerajona.java.designpatterns.creationals.builder.example3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HtmlElement {

    private String name;
    private String text;
    private final List<HtmlElement> elements = new ArrayList<>();
    private static final int INDENT_SIZE = 2;
    private static final String NEW_LINE = System.lineSeparator();

    public HtmlElement() {
    }

    public HtmlElement(String name, String text) {
        this.name = name;
        this.text = text;
    }

    private String toStringImpl(int indent) {
        StringBuilder sb = new StringBuilder();

        String i = String.join("", Collections.nCopies(indent * INDENT_SIZE, " "));
        sb.append(String.format("%s<%s>%s", i, name, NEW_LINE));

        if (text != null && !text.isEmpty()) {
            sb.append(String.join("", Collections.nCopies(INDENT_SIZE * (indent + 1), " ")))
                    .append(text)
                    .append(NEW_LINE);
        }

        elements.stream().map(e -> e.toStringImpl(indent + 1)).forEach(sb::append);

        sb.append(String.format("%s</%s>%s", i, name, NEW_LINE));
        return sb.toString();
    }

    @Override
    public String toString() {
        return toStringImpl(0);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addElement(HtmlElement element) {
        this.elements.add(element);
    }
}

class HtmlBuilder {
    private final String rootName;
    private HtmlElement root = new HtmlElement();

    public HtmlBuilder(String rootName) {
        this.rootName = rootName;
        root.setName(rootName);
    }

    // not fluent
    public void addChild(String childName, String childText) {
        HtmlElement e = new HtmlElement(childName, childText);
        root.addElement(e);
    }

    public HtmlBuilder addChildFluent(String childName, String childText) {
        HtmlElement e = new HtmlElement(childName, childText);
        root.addElement(e);
        return this;
    }

    public HtmlBuilder clear() {
        root = new HtmlElement();
        root.setName(rootName);
        return this;
    }

    // delegating
    @Override
    public String toString() {
        return root.toString();
    }
}