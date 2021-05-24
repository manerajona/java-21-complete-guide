package com.manerajona.java.programming.datastructures;

// Write a function that returns true if the brackets in a given string are balanced.
// The function must handle parenthesis (), square brackets [], and curly braces {}.

import java.util.Deque;
import java.util.LinkedList;

public class Queues {
    public static void main(String[] args) {
        System.out.println("(a[0]+b[2c[6]]) {24 + 53}  passed:" + bracesMatch("(a[0]+b[2c[6]]) {24 + 53}"));
        System.out.println("f(e(d))                    passed:" + bracesMatch("f(e(d))"));
        System.out.println("[()]{}([])                 passed:" + bracesMatch("[()]{}([])"));
        System.out.println("((b)                       passed:" + !bracesMatch("((b)"));
        System.out.println("(c]                        passed:" + !bracesMatch("(c]"));
        System.out.println("{(a[])                     passed:" + !bracesMatch("{(a[])"));
        System.out.println("([)]                       passed:" + !bracesMatch("([)]"));
        System.out.println(")(                         passed:" + !bracesMatch(")("));
        System.out.println(" (empty)                   passed:" + bracesMatch(""));
        System.out.println("null                       passed:" + !bracesMatch(null));
    }

    public static boolean bracesMatch(String sentence) {
        if (sentence == null)
            return false;

        Deque<Character> queue = new LinkedList<>();
        boolean match = true;
        for (char c : sentence.toCharArray()) {
            switch (c) {
                case '(': case '[': case '{':
                    queue.add(c);
                    match = false;
                    break;
                case ')':
                    if (queue.isEmpty()) return false;
                    match = queue.pollLast().equals('(') && queue.isEmpty();
                    break;
                case ']':
                    if (queue.isEmpty()) return false;
                    match = queue.pollLast().equals('[') && queue.isEmpty();
                    break;
                case '}':
                    if (queue.isEmpty()) return false;
                    match = queue.pollLast().equals('{') && queue.isEmpty();
                    break;
            }
        }
        return match;
    }

}