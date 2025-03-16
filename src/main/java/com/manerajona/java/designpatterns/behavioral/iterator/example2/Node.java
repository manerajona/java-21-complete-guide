package com.manerajona.java.designpatterns.behavioral.iterator.example2;

class Node<T> {
    private final T value;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
        if (left != null) {
            left.parent = this;
        }
        if (right != null) {
            right.parent = this;
        }
    }

    public T value() {
        return value;
    }

    public Node<T> parent() {
        return parent;
    }

    public Node<T> right() {
        return right;
    }

    public Node<T> left() {
        return left;
    }
}
