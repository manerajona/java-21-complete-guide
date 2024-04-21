package com.manerajona.java.designpatterns.creationals.singleton.example3;

import java.util.EnumMap;
import java.util.Map;

enum Subsystem {
    PRIMARY, AUXILIARY, FALLBACK
}

class Printer {

    private static final Map<Subsystem, Printer> instances = new EnumMap<>(Subsystem.class);

    private Printer() {
    }

    public static Printer get(Subsystem ss) {
        if (instances.containsKey(ss)) {
            return instances.get(ss);
        }

        Printer instance = new Printer();
        instances.put(ss, instance);
        return instance;
    }
}
