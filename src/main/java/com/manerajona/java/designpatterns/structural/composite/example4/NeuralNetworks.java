package com.manerajona.java.designpatterns.structural.composite.example4;

import java.util.*;
import java.util.function.Consumer;

interface SomeNeurons extends Iterable<Neuron> {
    default void connectTo(SomeNeurons other) {

        if (this == other) return;

        for (Neuron from : this) {
            for (Neuron to : other) {
                System.out.println("adding out " + to + " to " + from);
                from.addOut(to);
                System.out.println("adding in " + from + " to " + to);
                to.addIn(from);
            }
        }
    }
}

class Neuron implements SomeNeurons {

    private final Set<Neuron> in = new HashSet<>();

    private final Set<Neuron> out = new HashSet<>();

    @Override
    public Iterator<Neuron> iterator() {
        return Collections.singleton(this).iterator();
    }

    @Override
    public void forEach(Consumer<? super Neuron> action) {
        action.accept(this);
    }

    @Override
    public Spliterator<Neuron> spliterator() {
        return Collections.singleton(this).spliterator();
    }

    public Set<Neuron> in() {
        return Set.copyOf(this.in);
    }

    public Set<Neuron> out() {
        return Set.copyOf(this.out);
    }

    public void addIn(Neuron from) {
        this.in.add(from);
    }

    public void addOut(Neuron from) {
        this.out.add(from);
    }

    @Override
    public String toString() {
        return "Neuron{" +
                "in=" + in +
                ", out=" + out +
                '}';
    }
}

class NeuronLayer extends ArrayList<Neuron> implements SomeNeurons {
}
