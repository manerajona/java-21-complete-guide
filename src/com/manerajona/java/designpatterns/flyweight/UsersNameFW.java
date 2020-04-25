package com.manerajona.java.designpatterns.flyweight;

import com.google.common.base.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class UsersFW {
    public static void main(String[] args) {
        User user = new User("John Smith");
        User user1 = new User("Jane Smith");

        // have "Smith" in common
    }
}

class User {
    private String fullName;

    public User(String fullName) {
        this.fullName = fullName;
    }
}

class User2 {
    static List<String> nameValues = new ArrayList<>();
    private int[] nameIndexes;

    public User2(String fullName) {
        Function<String, Integer> getOrAdd = (String s) -> {
            int idx = nameValues.indexOf(s);
            if (idx != -1) return idx;
            else {
                nameValues.add(s);
                return nameValues.size() - 1;
            }
        };

        nameIndexes = Arrays
                .stream(fullName.split(" "))
                .mapToInt(getOrAdd::apply)
                .toArray();
    }

    public String getFullName() {
        return Arrays
                .stream(nameIndexes)
                .mapToObj(i -> nameValues.get(i))
                .collect(Collectors.joining(","));
    }
}