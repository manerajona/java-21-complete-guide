package com.manerajona.java.designpatterns.creationals.singleton;

import java.util.HashMap;

public class Multiton {
    public static void main(String[] args) {
        Printer main = Printer.get(Subsystem.PRIMARY);
        Printer aux = Printer.get(Subsystem.AUXILIARY);
        Printer aux2 = Printer.get(Subsystem.AUXILIARY);
    }
}

enum Subsystem {
    PRIMARY,
    AUXILIARY,
    FALLBACK
}

class Printer {

    private static HashMap<Subsystem, Printer> instances = new HashMap<>();

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
