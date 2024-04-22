package com.manerajona.java.designpatterns.creationals.builder.example2;

public interface Item {
    String name();

    Packing packing();

    float price();
}

abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }
}

class VegBurger extends Burger {

    @Override
    public float price() {
        return 3.50f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}

class ChickenBurger extends Burger {
    @Override
    public float price() {
        return 4.50f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}

abstract class SoftDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }
}

class Pepsi extends SoftDrink {
    @Override
    public float price() {
        return 1.50f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}

class Coke extends SoftDrink {
    @Override
    public float price() {
        return 1.75f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}