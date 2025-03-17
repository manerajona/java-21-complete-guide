package com.manerajona.java.designpatterns.behavioral.mediator.example2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

interface Mediator {
    void addBuyer(Buyer buyer);

    Optional<Buyer> findWinner();
}

class AuctionMediator implements Mediator {
    // this class implements the mediator interface and holds all the buyers in
    // an arraylist.  We can add buyers and find the highest bidder
    private final Set<Buyer> buyers;

    public AuctionMediator() {
        buyers = new HashSet<>();
    }

    @Override
    public void addBuyer(Buyer buyer) {
        buyers.add(buyer);
        System.out.println(buyer.name + " added to the buyers group.");
    }

    @Override
    public Optional<Buyer> findWinner() {
        return buyers.stream().max(Comparator.comparingInt(buyer -> buyer.bid));
    }
}
