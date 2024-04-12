package com.manerajona.java.programming.basics;

public class Operators
{
    public static void main(String... args){

        // Arithmetical operators
        int result = 100;
        System.out.println(result);
        int previousResult = result;
        result --;
        System.out.println("previous:" + previousResult);
        System.out.println("new result:" + result);
        result /= 2;
        System.out.println("new result:" + result);
        result *= 10;
        System.out.println("new result:" + result);
        result %= 2;
        System.out.println("new result:" + result);
        result ++;
        System.out.println("new result:" + result);

        String urAWinner = "You're a winner";

        // Logic operator
        if( (result >= 100) || (previousResult >= 100) && "You're a winner".equals(urAWinner) ) {
            System.out.println("You got the high score!");
        } else {
            System.out.println("Keep working!");
        }

        boolean isCar = false;
        boolean itWasACar = (isCar == false) ? true : false;
        if(itWasACar = true) {
            System.out.println("you're assigning and evaluating, now itWasACar is " + itWasACar);
        }

    }
}
