package com.manerajona.java.designprinciples.solid.singleresponsability.example2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Journal {
    private final List<String> entries = new ArrayList<>();

    private int count = 0;

    public void addEntry(String text) {
        ++count;
        entries.add(count + ": " + text);
    }

    public void removeEntry(int index) {
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }

    // here we break SRP
    public void save(String filename) throws FileNotFoundException // anti-pattern
    {
        try (PrintStream out = new PrintStream(filename)) {
            out.println(this);
        }
    }

    public void load(String filename) {
    }  // anti-pattern

    public void load(URL url) {
    } // anti-pattern
}

// handles the responsibility of persisting objects (separation of concerns)
class Persistence {
    public void saveToFile(Journal journal, String filename, boolean overwrite) throws FileNotFoundException {
        if (overwrite || new File(filename).exists())
            try (PrintStream out = new PrintStream(filename)) {
                out.println(journal.toString());
            }
    }

    public void load(Journal journal, String filename) {
    }

    public void load(Journal journal, URL url) {
    }
}
