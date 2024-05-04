package com.manerajona.java.designpatterns.structural.proxy.example2;

public class Main {
    public static void main(String [] args) {
        Internet internet = new Firewall();
        try {
            internet.connectTo("jasonfedin.org");
            internet.connectTo("hackers.com");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
