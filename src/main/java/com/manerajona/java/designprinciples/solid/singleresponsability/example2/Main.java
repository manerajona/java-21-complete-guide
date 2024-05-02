package com.manerajona.java.designprinciples.solid.singleresponsability.example2;

public class Main {
    public static void main(String[] args) throws Exception {
        Journal j = new Journal();
        j.addEntry("I cried today");
        j.addEntry("I ate a bug");
        j.addEntry("I buy a new bike");
        System.out.println(j);

        Persistence p = new Persistence();
        String filename = "/tmp/journal.txt";
        p.saveToFile(j, filename, true);

        // windows!
        //Runtime.getRuntime().exec("notepad.exe " + filename);
    }
}
