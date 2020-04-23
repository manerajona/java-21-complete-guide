package com.manerajona.java.programming.datastructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Linked {

    public static void main(String[] args) {/*
        Customer customer = new Customer("Tim", 2000.2);
        Customer anotherCustomer = customer;
        anotherCustomer.addTransaction(1000);
        System.out.println("Balance for" + customer.getName() + " is " + customer.getTransactions());
*/
        java.util.List<Integer> intList = new ArrayList<>() {
            {
                add(1);
                add(3);
                add(4);
            }
        };

        intList.forEach(System.out::println);

        intList.add(1, 2); // Insert in a position or remove is expensive

        intList.forEach(System.out::println);

        // LinkedList

        java.util.List<String> placesToVisit = new LinkedList<>() {{
            add("Sydney");
            add("Melbourne");
            add("Brisbane");
            add("Perth");
            add("Canberra");
        }};

        //placesToVisit.forEach(System.out::println);

        placesToVisit.add(1, "Adelaide");

        //placesToVisit.forEach(System.out::println);

        placesToVisit.remove (4);

        //placesToVisit.forEach(System.out::println);

        addUnique("Canberra", placesToVisit);
        addUnique("Alice Springs", placesToVisit);
        addUnique("Perth", placesToVisit);

        placesToVisit.forEach(System.out::println);

        System.out.println("**reverse**");

        // Linkedlist implements a double linked list so we can iterate in reverse
        printReverse1((LinkedList) placesToVisit);
        printReverse2((LinkedList) placesToVisit);
     }

     private static void addUnique(String city, java.util.List places) {
         for (ListIterator<String> iterator = places.listIterator(); iterator.hasNext(); ) {
             int comparison = iterator.next().compareTo(city);
             if(comparison == 0) {
                 return;
             }
         }
         places.add(city);
     }

    private static void printReverse1(LinkedList places) {
        for (Iterator iterator = places.descendingIterator(); iterator.hasNext(); System.out.println(iterator.next())) {}
    }

    private static void printReverse2(LinkedList places) {
        for (ListIterator iterator = places.listIterator(places.size()); iterator.hasPrevious(); System.out.println(iterator.previous())) {}
    }

}
