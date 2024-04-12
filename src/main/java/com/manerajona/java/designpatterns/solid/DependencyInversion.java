package com.manerajona.java.designpatterns.solid;

import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DependencyInversion {
    public static void main(String[] args)
    {
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        // low-level module
        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        new Research(relationships);
    }
}

// A. High-level modules should not depend on low-level modules.
// Both should depend on abstractions.

// B. Abstractions should not depend on details.
// Details should depend on abstractions.

enum Relationship {
    PARENT,
    CHILD,
    SIBLING
}

class Person {
    public String name;
    // dob etc.

    public Person(String name) {
        this.name = name;
    }
}

interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}

class Relationships implements RelationshipBrowser {

    public void addParentAndChild(Person parent, Person child) {
        relations.add(Triple.of(parent, Relationship.PARENT, child));
        relations.add(Triple.of(child, Relationship.CHILD, parent));
    }

    public List<Person> findAllChildrenOf(String name) {
        return relations
                .stream()
                .filter(x -> Objects.equals(x.getLeft().name, name) && x.getMiddle() == Relationship.PARENT)
                .map(Triple::getRight)
                .collect(Collectors.toList());
    }

    // Triplet class requires javatuples
    private List<Triple<Person, Relationship, Person>> relations = new ArrayList<>();

    public List<Triple<Person, Relationship, Person>> getRelations() {
        return relations;
    }
}

class Research {
    /*public Research(Relationships relationships) {
        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();

        // high-level: find all of john's children
        relations
                .stream()
                .filter(x -> x.getValue0().name.equals("John") && x.getValue1() == Relationship.PARENT)
                .forEach(ch -> System.out.println("John has a child called " + ch.getValue2().name));
    }*/

    public Research(RelationshipBrowser browser)  {
        List<Person> children = browser.findAllChildrenOf("John");
        children.stream().map(child -> "John has a child called " + child.name).forEach(System.out::println);
    }
}
