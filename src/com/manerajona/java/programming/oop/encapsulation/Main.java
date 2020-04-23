package com.manerajona.java.programming.oop.encapsulation;

public class Main {

    public static void main(String[] args) {

        Player player1 = new Player("Tim", 50, "Axe");
        Player player2 = new Player("Jona", 50, "Sword");

        player1.loseHealth(60);
        player2.loseHealth(40);

        System.out.println("Player 1 health " + player1.getHealth());
        System.out.println("Player 2 health " + player2.getHealth());

    }
}
