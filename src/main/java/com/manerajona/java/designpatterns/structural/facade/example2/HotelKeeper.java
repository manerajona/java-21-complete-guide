package com.manerajona.java.designpatterns.structural.facade.example2;

class HotelKeeper {

    public VegMenu getVegMenu() {
        VegRestaurant v = new VegRestaurant();
        return (VegMenu) v.getMenus();
    }

    public NonVegMenu getNonVegMenu() {
        NonVegRestaurant v = new NonVegRestaurant();
        return (NonVegMenu) v.getMenus();
    }

    public Both getVegNonMenu() {
        VegNonBothRestaurant v = new VegNonBothRestaurant();
        return (Both) v.getMenus();
    }
}
