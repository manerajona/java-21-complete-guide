package com.manerajona.java.designpatterns.behavioral.visitor.example2;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Client {

    private static final ArrayList<Consumer<Visitor>> items = new ArrayList<>();

    private static double calculatePostage(Visitor visitor) {
        //iterate through all items
        items.forEach(item -> item.accept(visitor));
        return visitor.getTotalPostage();
    }

    public static void main(String[] args) {
        // create a bunch of visitors (Book, CD, and DVD)
        Consumer<Visitor> myBook = new Book(8.52, 1.05);
        Consumer<Visitor> myCD = new CD(18.52, 3.05);
        Consumer<Visitor> myDVD = new DVD(6.53, 4.02);

        // add each visitor to the array list
        items.add(myBook);
        items.add(myCD);
        items.add(myDVD);

        double myPostage = calculatePostage(new USPostageVisitor());
        System.out.println("The total postage for my items shipped to the US is: " + myPostage);

        myPostage = calculatePostage(new SouthAmericaPostageVisitor());
        System.out.println("The total postage for my items shipped to South America is: " + myPostage);
    }
}
