package com.manerajona.java.designpatterns.behavioral.chainofresponsibility.example3;

class GoblinKing extends Goblin {

    public GoblinKing(Contest game) {
        super(game, 3, 3);
    }

    @Override
    public void query(AbstractPlayer source, StatisticQuery query) {
        // Every player gets +1 attac.
        if (source != this && Statistic.ATTACK.equals(query.statistic())) {
            query.incrementResult(1);
        }
        super.query(source, query);
    }
}
