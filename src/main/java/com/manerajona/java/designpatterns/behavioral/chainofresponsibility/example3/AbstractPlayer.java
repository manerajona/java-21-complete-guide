package com.manerajona.java.designpatterns.behavioral.chainofresponsibility.example3;

abstract class AbstractPlayer {
    protected Contest contest;
    protected int baseAttack;
    protected int baseDefense;

    protected AbstractPlayer(Contest contest, int baseAttack, int baseDefense) {
        this.contest = contest;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;

        contest.addPlayer(this);
        System.out.println(this + " added to " + contest);
    }

    public abstract int attack();

    public abstract int defense();

    public abstract void query(AbstractPlayer source, StatisticQuery sq);

    @Override
    public String toString() {
        return "Player{baseAttack=%d, baseDefense=%d, kind=%s}"
                .formatted(baseAttack, baseDefense, this.getClass().getSimpleName());
    }
}
