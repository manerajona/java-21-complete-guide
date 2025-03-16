package com.manerajona.java.designpatterns.behavioral.chainofresponsibility.example3;

final class StatisticQuery {
    private final Statistic statistic;
    private int result;

    StatisticQuery(Statistic statistic) {
        this.statistic = statistic;
    }

    public Statistic statistic() {
        return statistic;
    }

    public int result() {
        return result;
    }

    public void incrementResult(int value) {
        this.result += value;
    }
}