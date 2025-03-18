package com.manerajona.java.designpatterns.behavioral.strategy.example3;

import java.util.List;
import java.util.function.Supplier;

// STATIC IMPLEMENTATION (can't switch strategy at run time)
class TextProcessor<T extends ListStrategy> {
    private final StringBuilder sb = new StringBuilder();
    private final T listStrategy;

    public TextProcessor(Supplier<? extends T> supplier) {
        listStrategy = supplier.get();
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
