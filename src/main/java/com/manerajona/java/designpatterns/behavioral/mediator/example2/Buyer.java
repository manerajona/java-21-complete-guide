package com.manerajona.java.designpatterns.behavioral.mediator.example2;

abstract class Buyer {
    protected Mediator mediator;
    protected String name;
    protected int bid;

    Buyer(Mediator med, String name) {
        this.mediator = med;
        this.name = name;
    }

    public abstract void bid(int price);

    public abstract void cancelBid();

    public abstract void notifyWinner(Buyer winner);
}

class AuctionBuyer extends Buyer {

    public AuctionBuyer(Mediator group, String name) {
        super(group, name);

        group.addBuyer(this);
    }

    @Override
    public void bid(int price) {
        this.bid = price;
    }

    @Override
    public void cancelBid() {
        System.out.printf("%s canceled his bid.%n", name);
        this.bid = 0;
    }

    @Override
    public void notifyWinner(Buyer winner) {
        if (winner == this) {
            System.out.printf("[%s] The auction has ended. The winner is you!%n", this.name);
        } else {
            System.out.printf("[%s] The auction has ended. The winner is %s with $%s.%n", this.name, winner.name, winner.bid);
        }
    }
}
