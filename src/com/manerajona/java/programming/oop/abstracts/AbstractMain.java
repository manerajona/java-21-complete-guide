package com.manerajona.java.programming.oop.abstracts;

import com.manerajona.java.programming.oop.abstracts.mydatastructures.MyLinkedList;
import com.manerajona.java.programming.oop.abstracts.mydatastructures.Node;
import com.manerajona.java.programming.oop.abstracts.mydatastructures.SearchTree;

public class AbstractMain {
    public static void main(String[] args) {
/*        Dog dog = new Dog("Simon");
        dog.breathe();
        dog.eat();

        Bird bird = new Parrot("Parrot");
        bird.breathe();
        bird.eat();
        bird.fly();
        bird.openWigs();

        Bird penguin = new Penguin("Penguin");
        penguin.fly();*/


        MyLinkedList list = new MyLinkedList(null);
        list.traverse(list.getRoot());

        for (String s : "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Perth".split(" ")) {
            list.addItem(new Node(s));
        }
        list.traverse(list.getRoot());
        list.removeItem(new Node("Sydney"));
        list.traverse(list.getRoot());

        SearchTree searchTree = new SearchTree(null);
        searchTree.traverse(searchTree.getRoot());

        for (String s : "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Perth".split(" ")) {
            searchTree.addItem(new Node(s));
        }
        searchTree.traverse(searchTree.getRoot());
        searchTree.removeItem(new Node("Sydney"));
        searchTree.traverse(searchTree.getRoot());

    }


}
