package com.manerajona.java.programming.datastructures;

import java.util.Arrays;
import java.util.Scanner;

public class Array {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // ARRAYS
        int[] myArrayInt = new int[10];

        myArrayInt[0] = 10; // start
        myArrayInt[4] = 50; // middle
        myArrayInt[9] = 100; // last
        // Others will be initialized in zero

        int[] anotherArray = myArrayInt;

        anotherArray[1] = 1; // Both array changed because are referencing the same array in memory

        modifyArray(anotherArray);

        System.out.println("my Array =" + Arrays.toString(myArrayInt));
        System.out.println("another Array =" + Arrays.toString(anotherArray));

        restartArray(myArrayInt); // Change the reference but not the original array

        System.out.println("my Array =" + Arrays.toString(myArrayInt));
        System.out.println("another Array =" + Arrays.toString(anotherArray));

        System.out.println("The minimum value is " + findMin(anotherArray));

        reverse(anotherArray);

        System.out.println("The reverse array is " + Arrays.toString(anotherArray));

        for (int i = 0; i < myArrayInt.length; i++) {
            System.out.println(myArrayInt[i]);
        }

        double[] myArrayDouble = {.3333333d, 17.01d, 1e10d};
        for (double i : myArrayDouble) {
            System.out.println(i);
        }

        for (short s : new short[]{10, 20, 30}) { // Anonymous array
            System.out.println(s);
        }

        int[] arr = getIntegers(5);
        for(int i: sortIntegers(arr)){
            System.out.println(i);
        }

    }

    private static void modifyArray(int[] array) {
        array[2] = 2;
    }

    private static void restartArray(int[] array) {
        array = new int[]{1, 2, 3, 4, 5};
    }

    private static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for(int i : array) {
            if(i<min) {
                min = i;
            }
        }
        return min;
    }

    public static void reverse(int[] array) {
        int maxIndex = array.length -1;
        int halfLenght = array.length / 2;
        for (int n = 0; n<halfLenght; n++) {
            int temp = array[n];
            array[n] = array[maxIndex -n];
            array[maxIndex - n] = temp;
        }
    }

    public static int[] getIntegers(int n) {
        System.out.printf("Enter %d integer values \r\n", n);
        int[] values = new int[n];

        for (int i=values.length-1; i>0;i--) {
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public static int[] sortIntegers(int[] array) {

        int[] sortedArray = Arrays.copyOf(array, array.length);  // Copy all elements from one to other

        boolean flag = true;
        int temp;
        while(flag) {
            flag = false;

            for(int i=0; i<sortedArray.length-1; i++) {
                if(sortedArray[i] < sortedArray[i+1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;
                }
            }
        }

        return sortedArray;
    }
}
