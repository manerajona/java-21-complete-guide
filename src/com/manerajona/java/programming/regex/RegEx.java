package com.manerajona.java.programming.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    public static void main(String[] args) {

        // Replace regular expression
        String str = "I'm a string".replaceAll("I'm", "You're");
        System.out.println(str);

        String alphanumeric = "abcDEEEF11234 abcDEklasabc kKKKÑÑlLsSññ";
        // Character classes
        System.out.println("===============================================================");
        System.out.println(alphanumeric.replaceAll(".", "Y")); // Wildcard
        System.out.println(alphanumeric.replaceAll(".*", "Y")); // Wildcard greedy and zero
        System.out.println(alphanumeric.replaceAll(".+", "Y")); // Wildcard greedy and at least 1
        System.out.println(alphanumeric.replaceAll(".*?", "Y")); // Wildcard lazy
        System.out.println(alphanumeric.replaceAll("\\s", "")); // remove spaces
        System.out.println(alphanumeric.replaceAll("\\S", "S")); // replace all NON spaces
        System.out.println(alphanumeric.replaceAll("\\w", "")); // remove all words
        System.out.println(alphanumeric.replaceAll("\\W", "W")); // replace all NON words
        System.out.println(alphanumeric.replaceAll("\\d", "")); // remove all numeric digits
        System.out.println(alphanumeric.replaceAll("\\D", "D")); // Replace all NON numeric digits

        // Boundary matcher
        System.out.println("===============================================================");
        System.out.println(alphanumeric.replaceAll("^abcDEEEF", "START>")); // Boundary at start
        System.out.println(alphanumeric.replaceAll("ÑÑlLsS$", "<END")); // Boundary at the end
        System.out.println(alphanumeric.replaceAll("[abc]", "[X]")); // Boundary square braces for each individual char
        System.out.println(alphanumeric.replaceAll("[a][b][c]", "[XXX]")); // Boundary square braces pattern
        System.out.println(alphanumeric.replaceAll("[^abc]", "X")); // Boundary square braces negate each individual char
        System.out.println(alphanumeric.replaceAll("[a-k3-8]", "X")); // Boundary square braces from... to...
        System.out.println(alphanumeric.replaceAll("(?i)[a-k3-8]", "X")); // Boundary square braces not case sensitive
        System.out.println(alphanumeric.replaceAll("[0-9]", "X")); // Boundary square braces all numeric digit

        // Matches
        System.out.println("===============================================================");
        System.out.println(alphanumeric.matches("^abcDEEEF")); // false
        System.out.println("Harry".matches("[Hh]arry") && "harry".matches("[Hh]arry")); // true

        // Quantifiers
        System.out.println("===============================================================");
        System.out.println(alphanumeric.replaceAll("^abcDE{3}", "YYY")); // Quantifier exactly 3 'E' at start
        System.out.println(alphanumeric.replaceAll("^abcDE{2,4}", "YYY")); // Quantifier 2 to 4 'E' at start
        System.out.println(alphanumeric.replaceAll("^abcDE{8,10}", "YYY")); // Quantifier 8 to 10 'E' at start
        System.out.println(alphanumeric.replaceAll("^abcD+", "YYY")); // Quantifier ONE or more 'D' at start
        System.out.println(alphanumeric.replaceAll("^abcX*", "YYY")); // Quantifier ZERO or more 'X' at start

        // AND OR NOT
        System.out.println("===============================================================");
        // OR
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));

        // NOT
        String tvTest = "tstvtkt";
        //String tNotVRegExp = "t[^v]"; // 't' MUST be follow by 'v'

        // NEGATIVE LOOK AHEAD t(?!v)
        // POSITIVE LOOK AHEAD t(?=v)

        String tNotVRegExp = "t(?!v)"; // 't' CAN be follow by 'v', cause ! no consume a character
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        for (int count = 0;tNotVMatcher.find();count++) {
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        // Phone Validation
        // ^( [\(]{1} [0-9]{3} [\)]{1} [ ]? [0-9]{3} [\-]{1} [0-9]{4} )$
        String phone1 = "1234567890";  // Shouldn't match
        String phone2 = "(123) 456-7890"; // match
        String phone3 = "123 456-7890"; // Shouldn't match
        String phone4 = "(123)456-7890"; // match

        System.out.println("phone1 = " + phone1.matches("^([(][0-9]{3}[)][ ]?[0-9]{3}[\\-][0-9]{4})$"));
        System.out.println("phone2 = " + phone2.matches("^([(][0-9]{3}[)][ ]?[0-9]{3}[\\-][0-9]{4})$"));

        System.out.println("phone3 = " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]?[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone4 = " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]?[0-9]{3}[\\-]{1}[0-9]{4})$"));

        // Visa Validation
        // ^ 4 [0-9]{12} ([0-9]{3})? $
        String visa1 = "4444444444444"; // match
        String visa2 = "5444444444444"; // shouldn't match
        String visa3 = "4444444444444444";  // match
        String visa4 = "4444";  // shouldn't match

        System.out.println("visa1 " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));

    }
}
