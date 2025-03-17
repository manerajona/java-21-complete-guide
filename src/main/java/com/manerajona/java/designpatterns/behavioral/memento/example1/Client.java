package com.manerajona.java.designpatterns.behavioral.memento.example1;

public class Client {
    public static void main(String[] args) {

        FileWriter fileWriter = new FileWriter("data.txt");
        fileWriter.write("""
                They come in waves,
                my feelings for you.
                """);

        System.out.println(fileWriter);
        System.out.println("---------------------------------------------");

        //lets save the file
        fileWriter.save();

        // now write something else
        fileWriter.write("""
                And not pretty whitecaps
                dancing at my feet.
                """);

        System.out.println(fileWriter);
        System.out.println("---------------------------------------------");

        // lets undo to last save
        fileWriter.undoToLastSave();

        System.out.println(fileWriter);
    }
}
