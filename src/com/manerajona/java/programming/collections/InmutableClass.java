package com.manerajona.java.programming.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Strategy for Defining Immutable Objects:
 * 1. Do NOT provide setters
 * 2. Make fields PRIVATE FINAL
 * 3. Do not allow to override methods, the simplest way is declare de class as FINAL
 * 4. Do not share the references to the mutable objects, if necessary share a copies
 */

public final class InmutableClass {
    private final int id;
    private final String name;
    private final Map<String, Integer> values;

    public InmutableClass(int id, String name, Map<String, Integer> values) {
        this.id = id;
        this.name = name;
        this.values = (values != null) ? new HashMap<>(values) : new HashMap<>();
    }

    public final int getId() {
        return id;
    }

    public final String getName() {
        return name;
    }

    public final Map<String, Integer> getValues() {
        return Collections.unmodifiableMap(values);
    }
}
