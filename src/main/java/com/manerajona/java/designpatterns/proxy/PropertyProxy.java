package com.manerajona.java.designpatterns.proxy;

import java.util.Objects;

class PropertyProxy {
    public static void main(String[] args) {
        Creature c = new Creature();
        c.setAgility(12);
    }
}

class Property<T> {

    private T value;

    public Property(T value) {
        this.value = value;
    }

    public void setValue(T value) {
        // do some logging here
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property<?> property = (Property<?>) o;
        return Objects.equals(value, property.value);
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}

class Creature {
    private Property<Integer> agility = new Property<>(10);

    public void setAgility(Integer value) {
        // we cannot do agility = value, sadly
        agility.setValue(value);
    }

    public Integer getAgility() {
        return agility.getValue();
    }
}
