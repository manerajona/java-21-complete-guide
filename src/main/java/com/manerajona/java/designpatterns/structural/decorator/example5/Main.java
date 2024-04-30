package com.manerajona.java.designpatterns.structural.decorator.example5;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {

        byte[] bytes = "Jason Fedin aaaBBBBcccDDDD".getBytes();
        try {

            InputStream in = new LowerCaseInputStream(new ByteArrayInputStream(bytes));

            int c;
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
