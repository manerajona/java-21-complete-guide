package com.manerajona.java.designpatterns.structural.flyweight.example3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

record User(String fullName) {
}

class User2 {

    private static final List<String> nameValues = new ArrayList<>();
    private final int[] nameIndexes;

    public User2(String fullName) {

        ToIntFunction<String> getOrAdd = s -> {
            int idx = nameValues.indexOf(s);
            if (idx != -1) {
                return idx;
            } else {
                nameValues.add(s);
                return nameValues.size() - 1;
            }
        };

        nameIndexes = Arrays.stream(fullName.split(" "))
                .mapToInt(getOrAdd)
                .toArray();
    }

    public String getFullName() {
        return Arrays.stream(nameIndexes)
                .mapToObj(nameValues::get)
                .collect(Collectors.joining(","));
    }
}