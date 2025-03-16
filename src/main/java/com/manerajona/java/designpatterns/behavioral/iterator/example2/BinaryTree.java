package com.manerajona.java.designpatterns.behavioral.iterator.example2;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

class BinaryTree<T> implements Iterable<T> {

    private final Node<T> root;

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    @Override
    public Iterator<T> iterator() {
        return new InOrderIterator<>(root);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (T item : this) {
            action.accept(item);
        }
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}
