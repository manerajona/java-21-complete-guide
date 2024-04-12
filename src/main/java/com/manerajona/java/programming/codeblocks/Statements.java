package com.manerajona.java.programming.codeblocks;

public class Statements {
    public static void main(String... args) {
        int
                myVar = 50
                ; // myVar = 50 is an expression

        ++                   myVar            ; // Java ignores white spaces

        System.out.println(
                "This is an" +
                "Expression" +
                ", this too=" + myVar);

        if(myVar>50){ // myVar > 50 is expression
            System.out.printf("My var is %d\n", myVar); // if statement
        } else {
            System.out.println("My var is too little!"); // else statement
        }
        // All the rest of the line from ; to ; are statements
        {
            // This is inside the code block
            int score = 800;
            System.out.printf("You score is %d\n", score);
        }
        // This is out of the code block
        int score = 900;
        System.out.printf("You score is %d\n", score);

        score = 1000;
        System.out.printf("You score is %d\n", score);
    }
}