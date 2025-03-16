package com.manerajona.java.designpatterns.behavioral.chainofresponsibility.example3;

class Client {
    public static void main(String[] args) {

        Contest contest = new Contest("Labyrinth");

        AbstractPlayer goblin1 = new Goblin(contest);
        System.out.println("goblin 1: attack=" + goblin1.attack() + ", defense=" + goblin1.defense());
        System.out.println("---------------------------------------------");

        AbstractPlayer goblin2 = new Goblin(contest);
        System.out.println("goblin 1: attack=" + goblin1.attack() + ", defense=" + goblin1.defense());
        System.out.println("goblin 2: attack=" + goblin2.attack() + ", defense=" + goblin2.defense());
        System.out.println("---------------------------------------------");

        AbstractPlayer king = new GoblinKing(contest);
        System.out.println("goblin 1: attack=" + goblin1.attack() + ", defense=" + goblin1.defense());
        System.out.println("goblin 2: attack=" + goblin2.attack() + ", defense=" + goblin2.defense());
        System.out.println("King: attack=" + king.attack() + ", defense=" + king.defense());
    }
}

