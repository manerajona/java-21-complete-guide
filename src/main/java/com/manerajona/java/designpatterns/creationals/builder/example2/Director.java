package com.manerajona.java.designpatterns.creationals.builder.example2;

class Director {

    public void construct(MealBuilderInterface builder) {
        builder.buildBurger();
        builder.buildDrink();
    }
}
