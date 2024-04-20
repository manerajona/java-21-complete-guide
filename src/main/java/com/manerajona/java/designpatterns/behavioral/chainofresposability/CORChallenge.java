package com.manerajona.java.designpatterns.behavioral.chainofresposability;

import java.util.ArrayList;
import java.util.List;

class CORChallenge
{
  public static void main(String[] args)
  {
    Contest game = new Contest();
    Goblin goblin = new Goblin(game);
    game.players.add(goblin);

    System.out.println(goblin);
    System.out.println("goblin 1:" + goblin.getAttack() + " " + goblin.getDefense());

    Goblin goblin2 = new Goblin(game);
    game.players.add(goblin2);
    System.out.println("---------------------------------------------");
    System.out.println(goblin2);
    System.out.println("goblin 1:" + goblin.getAttack() + " " + goblin.getDefense());
    System.out.println("goblin 2:" + goblin2.getAttack() + " " + goblin2.getDefense());

    GoblinKing goblin3 = new GoblinKing(game);
    game.players.add(goblin3);

    System.out.println("---------------------------------------------");
    System.out.println(goblin3);
    System.out.println("goblin 1:" + goblin.getAttack() + " " + goblin.getDefense());
    System.out.println("goblin 2:" + goblin2.getAttack() + " " + goblin2.getDefense());
    System.out.println("goblin 3:" + goblin3.getAttack() + " " + goblin3.getDefense());

  }
}

abstract class Player {
    protected Contest game;
    protected int baseAttack, baseDefense;

    public Player(Contest game, int baseAttack, int baseDefense) {
        this.game = game;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
    }

    public abstract int getAttack();

    public abstract int getDefense();

    public abstract void query(Object source, StatQuery sq);

  @Override
  public String toString() {
    return "Player{" +
            "game=" + game +
            ", baseAttack=" + baseAttack +
            ", baseDefense=" + baseDefense +
            '}';
  }
}

class Goblin extends Player {

    protected Goblin(Contest game, int baseAttack, int baseDefense) {
        super(game, baseAttack, baseDefense);
    }

    public Goblin(Contest game) {
        super(game, 1, 1);
    }

    @Override
    public int getAttack() {
        StatQuery q = new StatQuery(Statistic.ATTACK);
        for (Player c : game.players) {
            c.query(this, q);
        }
        return q.result;
    }

    @Override
    public int getDefense() {
        StatQuery q = new StatQuery(Statistic.DEFENSE);
        for (Player c : game.players) {
            c.query(this, q);
        }
        return q.result;
    }

    @Override
    public void query(Object source, StatQuery sq) {
        if (source == this) {
            switch (sq.statistic) {
                case ATTACK:
                    sq.result += baseAttack;
                    break;
                case DEFENSE:
                    sq.result += baseDefense;
                    break;
            }
        } else if (sq.statistic == Statistic.DEFENSE) {
            sq.result++;
        }
    }
}

class GoblinKing extends Goblin {

    public GoblinKing(Contest game) {
        super(game, 3, 3);
    }

    @Override
    public void query(Object source, StatQuery sq) {
        if (source != this && sq.statistic == Statistic.ATTACK) {
            sq.result++; // every goblin gets +1 attack
        } else super.query(source, sq);
    }
}

enum Statistic {
    ATTACK, DEFENSE
}

class StatQuery {
    public Statistic statistic;
    public int result;

    public StatQuery(Statistic statistic) {
        this.statistic = statistic;
    }
}

class Contest {
    public List<Player> players = new ArrayList<>();

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Players:");
    players.forEach(player -> sb.append(" ").append(player.getClass().getSimpleName())) ;
    return sb.toString();
  }
}