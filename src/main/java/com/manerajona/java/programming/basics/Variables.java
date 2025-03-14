package com.manerajona.java.programming.basics;

public class Variables {

    public static void main(String... args) {
        // int
        int myMaxInt = 2_147_483_647;
        System.out.println(myMaxInt);

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE + 1); // overfloaw
        System.out.println(Integer.MIN_VALUE - 1); // underfloaw

        //byte
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);

        //short
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MAX_VALUE);

        // long
        long myLong = 100_000_000_000_000_000L;
        System.out.println(myLong);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);

        for(short i=0; i < 10; i++){
            System.out.println(i);
        }

        // cast
        byte myByte = (byte) (Integer.MIN_VALUE / 2);
        short myShort = (short) (Integer.MIN_VALUE / 2);
        System.out.println("" + myByte + myShort);

        int myInt = 10;
        short sumShort = (short) (1000 + ( myInt + myShort));
        int sumInt = 1000 + ( myInt + myShort);
        int sumInt2 = (int) (1000 + ( myInt + myShort + myLong));
        long sumlong= 1000 + ( myInt + myShort + myLong);

        // decimal
        float myFloat = 5.25f / 2f;
        double myDouble = 5.25d / 2d;
        double anotherDouble = .25;
        float anotherFloat = (float) .25;

        double numberOfPounds = 200_000d;
        double poundToKg = numberOfPounds * .453592d;
        System.out.println(poundToKg);

        // char and boolean
        char myChar = 's';
        char myUnicode = '\u0044'; // D
        System.out.println("" + myChar + myUnicode);

        // String
        String myString = "This is a string";
        System.out.printf("My string %s\n", myString);
    }
}