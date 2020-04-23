package com.manerajona.java.programming.oop.classes;

import com.manerajona.java.programming.oop.inheritance.Animal;
import com.manerajona.java.programming.oop.inheritance.Dog;
import com.manerajona.java.programming.oop.inheritance.Fish;

public class Classes {

    public static void main(String[] args) {
        Car porche = new Car();
        porche.setModel("Caravan");
        System.out.println("The model of Porche is " + porche.getModel());

        Car fiat = new Car();
        fiat.setModel("Strada");
        System.out.println("The model of Fiat is " + fiat.getModel());

        Account johnAccount = new Account("A00001", "John Coleman");
        johnAccount.setBalance(1_000_000.0d);

        johnAccount.deposit(100_000.0d);
        johnAccount.withdrawal(100.0d);
        johnAccount.withdrawal(2_000_000.0d);

        // Inheritance
        Animal animal = new Animal("animal", 1, 1, 1, 1);
        animal.eat();

        Dog dog = new Dog("Simon", 4, 30, 2, 4, 1 ,48, "long hair");
        dog.eat();

        dog.walk();
        dog.run();

        // References vs Instances
        // IN JAVA EVERY OBJECT IS ACCEDED BY REFERENCE!!
        Fish goldfish = new Fish("Emilio", 1, 5, 2, 3); // Object goldfish is a new instance of a class Fish
        Fish anotherFish = goldfish; // anorherFish is pointing to the object golfish by reference

        System.out.println("Fish name is " + goldfish.getName());
        System.out.println("Fish name is " + anotherFish.getName());

        anotherFish.setName("Robbie"); // If name changes in one, changes in both
        System.out.println("Fish name is " + goldfish.getName());
        System.out.println("Fish name is " + anotherFish.getName());

    }
}
