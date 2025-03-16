package com.manerajona.java.designpatterns.behavioral.iterator.example2;

import java.util.Iterator;
import java.util.NoSuchElementException;

class InOrderIterator<T> implements Iterator<T> {

    private Node<T> current;

    public InOrderIterator(Node<T> root) {
        current = root;
        // Initialize to the leftmost node
        while (current != null && current.left() != null) {
            current = current.left();
        }
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (current == null) {
            throw new NoSuchElementException();
        }

        T result = current.value();

        // Move to the next node in in-order traversal
        if (current.right() != null) {
            // If there's a right subtree, move to its leftmost node
            current = current.right();
            while (current.left() != null) {
                current = current.left();
            }
        } else {
            // Otherwise, move up to the parent
            while (current.parent() != null && current == current.parent().right()) {
                current = current.parent();
            }
            current = current.parent();
        }
        return result;
    }
}

