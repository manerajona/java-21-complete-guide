package com.manerajona.java.programming.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patterns {
    public static void main(String[] args) {

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<H2>Summary</H2>");
        htmlText.append("<p>Here is the summary.</p>");

        //Pattern pattern = Pattern.compile(".*<H2>.*", Pattern.CASE_INSENSITIVE);
        Pattern pattern = Pattern.compile("<H2>", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches()); // true

        matcher.reset(); // For reuse the matcher!!!
        for (int count = 1; matcher.find(); count++) {
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end()); // Two occurrences
        }

        // Groups
        System.out.println("===============================================================");
        String h2GroupPattern = "(<h2>.*?</h2>)"; // Lazy quantifier '?'
        Pattern groupPattern = Pattern.compile(h2GroupPattern, Pattern.CASE_INSENSITIVE);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(0)); // Group
            System.out.println("Occurrence: " + groupMatcher.group(1)); // Sub-group
        }

        System.out.println("===============================================================");
        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPatten = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPatten.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (h2TextMatcher.find()) {
            System.out.println("Occurrence: " + h2TextMatcher.group(0)); // Entire String group
            System.out.println("Occurrence: " + h2TextMatcher.group(1)); // <h1>
            System.out.println("Occurrence: " + h2TextMatcher.group(2)); // Content tag
            System.out.println("Occurrence: " + h2TextMatcher.group(3)); // </h1>
        }
    }
}
