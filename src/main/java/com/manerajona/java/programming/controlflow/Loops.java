package com.manerajona.java.programming.controlflow;

public class Loops {
    public static void main(String... args) {
        System.out.println( getLargestPrime(21) );
        System.out.println( getLargestPrime(45) );
        System.out.println( getLargestPrime(7) );
        System.out.println( getLargestPrime(16) );

    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOdd(int num) {
        return num > 0 && num%2!=0;
    }

    public static boolean isEven(int num) {
        return num > 3 && num%2==0;
    }

    public static int sumDigits(int number) {
        if(number < 10) {
            return -1;
        }
        int sum = 0;
        while (number > 0) {
            // extract the less-significant digit
            int digit = number % 10;
            sum += digit;

            // drop the less-significant digit
            number /= 10;
        }
        return sum;
    }

    public static boolean isPalindrome(int number) {
        int reverse = 0;
        for (int n = number; n != 0; n /= 10) {
            reverse = reverse * 10 + n % 10;
        }
        System.out.print(reverse);
        return reverse == number;
    }

    public static int sumFirstAndLastDigit(int number) {
        if (number >= 0) {
            int last = number % 10;
            int first = last;
            for (int n = number; n != 0; n /= 10) {
                first = n;
            }
            return last + first;
        }
        return -1;
    }

    public static int getEvenDigitSum(int number) {
        if (number >= 0) {
            int sum = 0;
            for (int n = number; n != 0; n /= 10) {
                int last = n % 10;
                sum += (last) % 2 == 0 ? last : 0;
            }
            return sum;
        }
        return -1;
    }

    public static boolean hasSharedDigit(int a, int b) {
        String bs = String.valueOf(b);
        for (int n = a; n != 0; n /= 10) {
            String digit = String.valueOf(n%10);
            if (!bs.contains(digit)) {
                continue;
            }
            return true;
        }
        return false;
    }

    public static boolean hasSameLastDigit(int a, int b, int c) {
            return (a % 10 == b % 10) && (a % 10 == c % 10);
    }

    public static int getGreatestCommonDivisor(int a, int b) {
        int divisor = -1;
        if (a >= 10 && b >= 10) {
            for (int d = 2; a/d != 0 && b/d != 0; d++) {
                if (a % d == 0 && b % d == 0) {
                    divisor = d;
                }
            }
        }
        return divisor;
    }

    public static void printFactors(int number) {

        if(number>0) {
            for (int d = 1; number/d != 0; d++) {
                if (number % d == 0) {
                    System.out.println(d);
                }
            }
        } else {
            System.out.println("Invalid Value");
        }
    }

    public static boolean isPerfectNumber(int number) {
        if (number > 0) {
            int sum = 0;
            for (int d = 1; number / d != 1; d++) {
                if (number % d == 0) {
                    sum += d;
                }
            }
            return number == sum;
        }
        return false;
    }


    /*FIXME this logic sucks!!
    *  It doesn work for uc number=16*/
    public static int getLargestPrime(int number) {
        if(number>1) {
            int largestPrime = number;
            for (int i = 2; i <= number; i++) {
                if (number % i == 0) {
                    largestPrime = Math.max(i, number / i);
                    number = largestPrime;
                }
            }
            return largestPrime != 4 ? largestPrime : 2;
        }
        return -1;
    }

}