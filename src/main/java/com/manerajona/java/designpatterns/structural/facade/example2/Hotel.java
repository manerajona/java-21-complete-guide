package com.manerajona.java.designpatterns.structural.facade.example2;

interface Hotel {
    Menus getMenus();
}

class NonVegRestaurant implements Hotel {
    @Override
    public Menus getMenus() {
        return new NonVegMenu();
    }
}

class VegRestaurant implements Hotel {
    @Override
    public Menus getMenus() {
        return new VegMenu();
    }
}

class VegNonBothRestaurant implements Hotel {
    @Override
    public Menus getMenus() {
        return new Both();
    }
}
