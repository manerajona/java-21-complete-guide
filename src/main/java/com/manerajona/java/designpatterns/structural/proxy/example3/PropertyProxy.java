package com.manerajona.java.designpatterns.structural.proxy.example3;

import java.util.Objects;

class PropertyProxy<T> {

    private T property;

    public PropertyProxy(T value) {
        this.property = value;
    }

    public T getProperty() {
        return property;
    }

    public void setProperty(T property) {
        this.property = property;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyProxy<?> property = (PropertyProxy<?>) o;
        return Objects.equals(this.property, property.property);
    }

    @Override
    public int hashCode() {
        return property != null ? property.hashCode() : 0;
    }
}
