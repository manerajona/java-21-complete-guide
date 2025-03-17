package com.manerajona.java.designpatterns.behavioral.memento.example1;

public class FileWriter {
    private Memento snapshot;
    private String filename;
    private StringBuilder content;

    public FileWriter(String filename) {
        this.filename = filename;
        this.content = new StringBuilder();
        this.snapshot = new Memento(filename, content);
    }

    @Override
    public String toString() {
        return this.content.toString();
    }

    public void write(String str) {
        content.append(str);
    }

    public void save() {
        // creates the memento
        this.snapshot = new Memento(filename, content);
    }

    // restore into its earlier change
    public void undoToLastSave() {
        this.filename = snapshot.filename();
        this.content = snapshot.content();
    }

    private record Memento(String filename, StringBuilder content) {

        public Memento(String filename, StringBuilder content) {
            this.filename = filename;
            // notice the deep copy so that Memento and FileWriterUtil
            // content variables don't refer to same object
            this.content = new StringBuilder(content);
        }
    }
}
