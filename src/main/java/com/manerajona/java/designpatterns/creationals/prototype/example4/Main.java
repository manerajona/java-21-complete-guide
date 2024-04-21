package com.manerajona.java.designpatterns.creationals.prototype.example4;

import org.apache.commons.lang3.SerializationUtils;

public class Main {
    public static void main(String[] args) {
        SerializationPrototype foo = new SerializationPrototype(42, "life");
        // use apache commons!
        SerializationPrototype foo2 = SerializationUtils.roundtrip(foo); // brand-new foo

        foo2.setWhatever("xyz");

        System.out.println(foo);
        System.out.println(foo2);
    }
}