package com.manerajona.java.designprinciples.solid.dependencyinversion.example2;

import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;
import java.util.List;

// A. High-level modules should not depend on low-level modules.
// Both should depend on abstractions.

// B. Abstractions should not depend on details.
// Details should depend on abstractions.

enum Relationship {
    PARENT,
    CHILD,
    SIBLING
}

record Person(String name) {
}

interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}

class Relationships implements RelationshipBrowser {

    // Triplet class requires javatuples
    private final List<Triple<Person, Relationship, Person>> relations = new ArrayList<>();

    public List<Triple<Person, Relationship, Person>> getRelations() {
        return List.copyOf(relations);
    }

    public void addParentAndChild(Person parent, Person child) {
        relations.add(Triple.of(parent, Relationship.PARENT, child));
        relations.add(Triple.of(child, Relationship.CHILD, parent));
    }

    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream()
                .filter(tuple -> tuple.getLeft().name().equals(name) && tuple.getMiddle().equals(Relationship.PARENT))
                .map(Triple::getRight)
                .toList();
    }
}

class Research {

    // high-level: find all of john's children
    public Research(String name, Relationships relationships) {
        relationships.getRelations().stream()
                .filter(tuple -> tuple.getLeft().name().equals(name) && tuple.getMiddle().equals(Relationship.PARENT))
                .map(child -> "%s has a child called %s".formatted(name, child.getRight().name()))
                .forEach(System.out::println);
    }

    // low-level: find all of john's children
    public Research(String name, RelationshipBrowser browser) {
        browser.findAllChildrenOf(name).stream()
                .map(child -> "%s has a child called %s".formatted(name, child.name()))
                .forEach(System.out::println);
    }
}
