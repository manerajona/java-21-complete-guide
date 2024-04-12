package com.manerajona.java.programming.io;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exceptions {

    public static void main(String[] args) {
        try {

        int x = getIntEAFP();
        int y = getIntEAFP();
        System.out.println(divideEAFP(x, y));
        System.out.println(divideLBYL(x, y));
        } catch (ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("Unable to perform the division");
        }
    }

    // LBYL (Look Before You Leap):
    private static int divideLBYL(int x, int y) {
        if(y!=0) {
            return x / y;
        } else {
            throw new ArithmeticException("attempt to divide by zero");
        }
    }

    // EAFP (it's Easier to Ask Forgiveness than Permission):
    private static int divideEAFP(int x, int y) {
        try {
            return x/y;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("attempt to divide by zero");
        }
    }

    private static int getIntEAFP() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer");
        while (true) {
            try {
                return s.nextInt();
            } catch (InputMismatchException e) {
                s.nextLine();
                System.out.println("Only integers allowed");
            } catch (NoSuchElementException e) {
                throw new NoSuchElementException("Input interrupted on purpose");
            }
        }
    }
}
