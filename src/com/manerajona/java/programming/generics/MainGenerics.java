package com.manerajona.java.programming.generics;

import com.manerajona.java.programming.generics.sports.FootballPlayer;
import com.manerajona.java.programming.generics.sports.RugbyPlayer;
import com.manerajona.java.programming.generics.sports.Team;

import java.util.ArrayList;

public class MainGenerics {
    public static void main(String[] args) {

        // Using Object class
        ArrayList items = new ArrayList();
        items.add(1);
        items.add(2);
        items.add(3);
        items.add(4);
        items.add(5);
        items.forEach(i ->  System.out.println((Integer) i * 2));

        // Using Generics

        FootballPlayer joe = new FootballPlayer("Joe");

        Team<FootballPlayer> talleres = new Team<>("Talleres");
        talleres.addPlayer(joe);

        //Team<String> error = new Team<>("Error"); This is not allowed cause T extends Player

        System.out.println(talleres.numOfPlayers());

        RugbyPlayer ben = new RugbyPlayer("Ben");
        RugbyPlayer pat = new RugbyPlayer("Pat");
        RugbyPlayer juan = new RugbyPlayer("Juan");
        RugbyPlayer felipe = new RugbyPlayer("Felipe");

        Team<RugbyPlayer> sharks = new Team<>("Sharks");
        // sharks.addPlayer(joe); compiling error
        sharks.addPlayer(ben);
        sharks.addPlayer(pat);

        Team<RugbyPlayer> jaguars = new Team<>("Jaguars");
        jaguars.addPlayer(juan);
        jaguars.addPlayer(felipe);

        jaguars.matchResult(sharks, 45, 30);
        jaguars.matchResult(sharks, 25, 30);
        jaguars.matchResult(sharks, 35, 30);

        System.out.println(jaguars.compareTo(sharks));
        System.out.println(sharks.compareTo(jaguars));

    }
}
