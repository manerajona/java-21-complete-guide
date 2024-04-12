package com.manerajona.java.programming.oop.abstracts.mydatastructures;

public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.rightLink;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.rightLink = item;
        return next();
    }

    @Override
    ListItem previous() {
        return this.leftLink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.leftLink = item;
        return previous();
    }

    @Override
    int compareTo(ListItem item) {
        return (item != null ?
                ((String) super.getValue()).compareTo((String) item.getValue()) :
                -1);
    }
}
