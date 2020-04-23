package com.manerajona.java.programming.functional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");

        // Stream chain
        someBingoNumbers
                .stream()                           // Stream pipe is created when the chain is evaluated, it consists en zero to N operations and a terminal
                .map(String::toUpperCase)           // Returns a stream consisting of the results of applying the given function to the elements of this stream
                .filter(s -> s.startsWith("G"))     // Returns a stream consisting of the elements of this stream that match the given predicate
                .sorted()                           // Returns a stream consisting of the elements of this stream, sorted according to natural order
                .forEach(System.out::println);      // Method reference -> Class::Method

        // Stream from scratch
        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);

        System.out.println("-----------------------");
        System.out.println(concatStream
                .distinct()                        // Returns a stream consisting of the distinct elements
                .peek(System.out::println)         // Returns a stream and performs a function
                .count());                         // Returns a long with the count of elements in this stream

    }
}