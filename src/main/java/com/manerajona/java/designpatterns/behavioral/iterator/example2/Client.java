package com.manerajona.java.designpatterns.behavioral.iterator.example2;

class Client {
    public static void main(String[] args) {
        //   1
        //  / \
        // 2   3
        Node<Integer> root = new Node<>(1, new Node<>(2), new Node<>(3));

        InOrderIterator<Integer> it = new InOrderIterator<>(root);
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        BinaryTree<Integer> tree = new BinaryTree<>(root);
        tree.forEach(i -> System.out.print(i + " "));
        System.out.println();
    }
}
