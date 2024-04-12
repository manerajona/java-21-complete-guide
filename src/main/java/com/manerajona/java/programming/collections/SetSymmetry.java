package com.manerajona.java.programming.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetSymmetry {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for(int i=1; i<=100; i++) {
            squares.add(i*i);
            cubes.add(i*i*i);
        }
/*        squares.forEach(System.out::println);
        cubes.forEach(System.out::println);*/

        System.out.println("==============================");
        // UNION (SYMMETRIC)
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        union.forEach(System.out::println);

        System.out.println("==============================");
        // INTERSECTION (SYMMETRIC)
        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        intersection.forEach(System.out::println);


        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(natureWords));

        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        // DIFFERENCE (ASYMMETRIC)

        System.out.println("nature - divine:");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("divine - nature:");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        // DIFFERENCE (SYMMETRIC)

        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);

        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);

        System.out.println("Symmetric difference");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        // SUBSETS

        if(nature.containsAll(divine)) {
            System.out.println("divine is a subset of nature");
        }

        if(nature.containsAll(intersectionTest)) {
            System.out.println("intersection is  subset of nature");
        }

        if(divine.containsAll(intersectionTest)) {
            System.out.println("intersection is a subset of divine");
        }

    }

    private static void printSet(Set<String> set) {
        System.out.print("\t");
        for(String s : set) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
