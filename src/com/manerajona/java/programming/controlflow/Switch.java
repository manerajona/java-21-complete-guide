package com.manerajona.java.programming.controlflow;

public class Switch {
    public static void main(String... args) {

        int switchVal = 7;

        while(switchVal>0) {
            switch (switchVal) {
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3: case 4: case 5:
                    System.out.println("Three, four or five");
                    System.out.println("Actually was a " + switchVal);
                    break;
                default:
                    System.out.println("Was not one, two, three, four or five");
                    break;
            }
            switchVal--;
        }

        for (String s : new String[]{"Jan", "Feb", "mar", "apr", "hello"}) {
            switch (s.toUpperCase()) {
                case "JAN":
                    System.out.println("Is January");
                    break;
                case "FEB":
                    System.out.println("Is February");
                    break;
                case "MAR":
                    System.out.println("Is March");
                    break;
                case "APR":
                    System.out.println("Is April");
                    break;
                default:
                    System.out.println("Month not found");
                    break;
            }
        }
    }

    public static int getDaysInMonth(int month, int year) {
        int ret = -1;
        if(month > 0 && month < 13 && year > 0 && year < 10_000) {
            switch(month) {
                case 4: case 6: case 9: case 11:
                    ret = 30;
                    break;
                case 2:
                    ret = isLeapYear(year) ? 29 : 28;
                    break;
                default :
                    ret = 31;
                    break;
            }
        }
        return ret;
    }


    public static boolean isLeapYear(int year) {
        return (year > 0 && year < 10_000) && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }

}