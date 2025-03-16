package com.manerajona.java.designpatterns.behavioral.chainofresponsibility.example3;

class Goblin extends AbstractPlayer {

    protected Goblin(Contest contest, int baseAttack, int baseDefense) {
        super(contest, baseAttack, baseDefense);
    }

    public Goblin(Contest contest) {
        super(contest, 1, 1);
    }

    @Override
    public int attack() {
        StatisticQuery query = new StatisticQuery(Statistic.ATTACK);
        contest.players().forEach(player -> player.query(this, query));
        return query.result();
    }

    @Override
    public int defense() {
        StatisticQuery query = new StatisticQuery(Statistic.DEFENSE);
        contest.players().forEach(player -> player.query(this, query));
        return query.result();
    }

    @Override
    public void query(AbstractPlayer source, StatisticQuery query) {
        if (source == this) {
            if (Statistic.ATTACK.equals(query.statistic())) {
                query.incrementResult(baseAttack);
            } else if (Statistic.DEFENSE.equals(query.statistic())) {
                query.incrementResult(baseDefense);
            }
        }

        // Every player gets +1 defense.
        if (Statistic.DEFENSE.equals(query.statistic())) {
            query.incrementResult(1);
        }
    }
}
