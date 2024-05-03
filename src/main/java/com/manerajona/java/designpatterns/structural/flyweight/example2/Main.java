package com.manerajona.java.designpatterns.structural.flyweight.example2;

import java.util.Random;

public class Main {

    static final Random RANDOM = new Random();

    static final PlayerType[] playerType = {PlayerType.TERRORIST, PlayerType.COUNTER_TERRORIST};

    static final String[] weapons = {"AK-47", "Maverick", "Gut Knife", "Desert Eagle"};

    static PlayerType getRandPlayerType() {
        // Will return an integer between [0,2)
        int randInt = RANDOM.nextInt(playerType.length);
        // return the player stored at index 'randInt'
        return playerType[randInt];
    }

    static String getRandWeapon() {
        // Will return an integer between [0,5)
        int randInt = RANDOM.nextInt(weapons.length);
        // Return the weapon stored at index 'randInt'
        return weapons[randInt];
    }

    public static void main(String[] args) {
        /* Assume that we have a total of 10 players in the game. */
        for (int i = 0; i < 10; i++) {
            /* getPlayer() is called simply using the class name since the method is a static one */
            Player p = PlayerFactory.getPlayer(getRandPlayerType());
            /* Assign a weapon chosen randomly uniformly from the weapon array  */
            p.assignWeapon(getRandWeapon());
            // Send this player on a mission
            p.mission();
        }
    }
}
