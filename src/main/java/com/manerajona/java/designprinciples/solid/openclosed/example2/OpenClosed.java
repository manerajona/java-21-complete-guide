package com.manerajona.java.designprinciples.solid.openclosed.example2;

import java.util.List;
import java.util.stream.Stream;

enum Color {
    RED, GREEN, BLUE
}

enum Size {
    SMALL, MEDIUM, LARGE, YUGE
}

class Product {
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
}

class ProductFilter {
    public Stream<Product> filterByColor(List<Product> products, Color color) {
        return products.stream().filter(p -> p.color == color);
    }

    public Stream<Product> filterBySize(List<Product> products, Size size) {
        return products.stream().filter(p -> p.size == size);
    }

    public Stream<Product> filterBySizeAndColor(List<Product> products, Size size, Color color) { // anti-pattern
        return products.stream().filter(p -> p.size == size && p.color == color);
    }
    // state space explosion
    // 3 criteria = 7 methods
}

// we introduce two new interfaces that are open for extension
interface Specification<T> {
    boolean isSatisfied(T item);
}

interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> spec);
}

class ColorSpecification implements Specification<Product> {

    private final Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product p) {
        return p.color == color;
    }
}

class SizeSpecification implements Specification<Product> {

    private final Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product p) {
        return p.size == size;
    }
}

class AndSpecification<T> implements Specification<T> {
    private final Specification<T>[] specs;

    @SafeVarargs
    public AndSpecification(Specification<T>... specs) {
        this.specs = specs;
    }

    @Override
    public boolean isSatisfied(T item) {
        boolean isSatisfied = true;
        for (Specification<T> spec : specs) {
            if (!(isSatisfied = spec.isSatisfied(item))) break;
        }
        return isSatisfied;
    }

}

class BetterFilter implements Filter<Product> {
    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(spec::isSatisfied);
    }
}