package com.manerajona.java.programming.codeblocks;

public class Methods {

    public static final String INVALID_VALUE = "Invalid Value";
    public static final String TIME_FORMAT = "%02d";
    public static final String DAY_FORMAT = "%dd";

    public static void main(String... args) {

        System.out.println(printPages(5, true));
        System.out.println(printPages(6, false));
      /*  System.out.println(canPack(1, 0, 5));
        System.out.println(canPack(1, 0, 4));
        System.out.println(canPack(0, 5, 4));
        System.out.println(canPack(2, 1, 11));
        System.out.println(canPack(2, 2, 5));
        System.out.println(canPack(5, 3, 24));*/
    }

    public static long toMilesPerHour(double kilometersPerHour) {
        return kilometersPerHour >= 0 ?
                Math.round(kilometersPerHour / 1.609) :
                -1;
    }

    public static String getDurationString(long minutes) {
        String ret = INVALID_VALUE;
        if(minutes >= 0) {
            long hours = minutes / 60;
            String remainingMinutes = String.format(TIME_FORMAT, minutes%60);
            String days = String.format(DAY_FORMAT,hours / 24);
            String remainingHours = String.format(TIME_FORMAT, hours%24);
            ret = days+" "+remainingHours +":"+remainingMinutes;
        }
        return  ret;
    }

    // OVERLOADING

    public static boolean areEqualByThreeDecimalPlaces(double a, double b) {
        return areEqualByThreeDecimalPlaces((long) (a * 1e3), (long) (b * 1e3));
    }

    public static boolean areEqualByThreeDecimalPlaces(long a, long b) {
        return a == b;
    }

    // RECURSION

    public static int factorial(int n) {
        return n == 0 ? 1 : n * factorial((n - 1));
    }

    public static double area(double radius) {
        return radius > 0 ? (Math.PI * Math.PI * radius) : -1.0d;
    }

    public static double area(double x, double y) {
        return (x  > 0 && y  > 0) ? (x * y) : -1.0d;
    }

    public static void printEqual(int a, int b, int c) {
        String res = "Invalid Value";
        if (a >= 0 && b >= 0 && c >= 0) {
            boolean areAllEqual = a == b && a == c;
            if (areAllEqual) {
                res = "All numbers are equal";
            } else {
                boolean areAllDifferent = a != b && a != c && b != c;
                res = areAllDifferent ?
                        "All numbers are different" :
                        "Neither all are equal or different";
            }
        }
        System.out.println(res);
    }

    public static boolean isCatPlaying(boolean summer, int temperature){
        return summer ?
                (temperature <= 45 && temperature >= 35) :
                (temperature <= 35 && temperature >= 25) ;
    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        bigCount*=5;
        return  (goal>0) &&
                (bigCount+smallCount>=goal) &&
                (smallCount>=goal || bigCount%goal==0 || smallCount>=(5-(bigCount%goal)));
    }

    public static int printPages(int pages, boolean isDuplex) {
        return isDuplex ? (pages / 2) + (pages % 2) : pages;
    }
}
