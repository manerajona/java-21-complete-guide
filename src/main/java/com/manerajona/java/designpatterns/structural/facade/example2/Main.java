package com.manerajona.java.designpatterns.structural.facade.example2;

public class Main {
    public static void main(String[] args) {

        HotelKeeper keeper = new HotelKeeper();

        Menus v = keeper.getVegMenu();
        v.showMenu();

        Menus nv = keeper.getNonVegMenu();
        nv.showMenu();

        Menus b = keeper.getVegNonMenu();
        b.showMenu();
    }
}
