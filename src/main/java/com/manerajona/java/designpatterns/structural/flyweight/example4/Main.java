package com.manerajona.java.designpatterns.structural.flyweight.example4;

public class Main {
    public static void main(String[] args) {
        FormattedText ft = new FormattedText("This is a brave new world");
        ft.capitalize(10, 15);
        System.out.println(ft);

        BetterFormattedText bft = new BetterFormattedText("Make America Great Again");
        bft.getRange(13, 18).setCapitalize(true);
        bft.getRange(0, 11).setBold(true);
        System.out.println(bft);
    }
}
