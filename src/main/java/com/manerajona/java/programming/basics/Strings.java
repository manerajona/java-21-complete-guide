package com.manerajona.java.programming.basics;

import java.util.Scanner;

public class Strings {

    public static void main(String[] args) {
        String numberStr = "202";
        numberStr += 1; // same as concat
        System.out.printf("My String number %s\n", numberStr);

        int number = Integer.parseInt(numberStr);
        number += 1;
        System.out.printf("My number %d\n", number);

        String doublerStr = "80.7555d";
        Double doubleNumber = Double.parseDouble(doublerStr);
        System.out.printf("My number %.2f\n", doubleNumber);

        // Inputs from console
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + ", what is your age?");

        int age = 0;
        if (scanner.hasNextInt()) {
            age = scanner.nextInt();
            scanner.nextLine(); // Handle next line character (Enter key)
        }
        if(age > 0) {
            System.out.println("Great! Next year you will have " + (age + 1) + " years old.");
        } else {
            System.out.println("Invalid Value");
        }

        scanner.close();

    }
}
