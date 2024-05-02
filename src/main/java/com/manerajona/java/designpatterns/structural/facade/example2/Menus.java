package com.manerajona.java.designpatterns.structural.facade.example2;

interface Menus {
    void showMenu();
}

class NonVegMenu implements Menus {

    NonVegMenu() {
        System.out.println("Creating a non veg menu");
    }

    @Override
    public void showMenu() {
        System.out.println("Menu items in non veg menu");
    }
}

class VegMenu implements Menus {

    VegMenu() {
        System.out.println("Creating a veg Menu menu");
    }

    @Override
    public void showMenu() {
        System.out.println("Menu items in veg menu");
    }
}

class Both implements Menus {

    Both() {
        System.out.println("Creating both a non and veg menu");
    }

    @Override
    public void showMenu() {
        System.out.println("Menu items in both a veg and non menu");
    }
}
