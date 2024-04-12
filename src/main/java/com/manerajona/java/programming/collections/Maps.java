package com.manerajona.java.programming.collections;

import java.util.HashMap;
import java.util.Map;

public class Maps {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "OOP platform that runs in a VM machine");
        languages.put("Python", "OOP platform whit dynamic semantics");
        languages.put("GO", "Coolest language ever");
        languages.put("Javascript", "Scripting language prototype oriented");
        languages.put("Typescript", "Like Javascript with Types");

        // NULLS
        languages.put(null, "This is null");

        languages.forEach((k, v) -> System.out.println(k + " : " + v));

        // REMOVE
        languages.remove("Java");

        // Check if EXISTS
        if (!languages.containsKey("Java")) {
            languages.put("Java", "Most popular language of the decade");
        }

        // CREATE or UPDATE
        languages.put(null, "Just one element can be null");

        // Just UPDATE if EXISTS
        languages.replace("GO", "Imperative language based in C");

        System.out.println("==========================================");
        languages.forEach((k, v) -> System.out.println(k + " : " + v));

        // IF REMOVED THEN UPDATE
        if (languages.remove("Java", "Most popular language of the decade")) {
            languages.put("Java", "OOP platform that runs in a VM machine");
        }

        System.out.println("==========================================");
        languages.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
