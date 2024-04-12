package com.manerajona.java.designpatterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;

class Nodo<T> {
    public T value;
    public Nodo<T> left, right, parent;

    public Nodo(T value) {
        this.value = value;
    }

    public Nodo(T value, Nodo<T> left, Nodo<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;

        left.parent = right.parent = this;
    }

    private void traverse(Nodo<T> current, ArrayList<Nodo<T>> acc) {
        acc.add(current);
        if (current.left != null) {
            traverse(current.left, acc);
        }
        if (current.right != null) {
            traverse(current.right, acc);
        }
    }

    public Iterator<Nodo<T>> preOrder() {
        ArrayList<Nodo<T>> items = new ArrayList<>();
        traverse(this, items);
        return items.iterator();
    }
}