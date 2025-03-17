package com.manerajona.java.designpatterns.behavioral.mediator.example2;

import java.util.Random;

public class Client {

    private static final Random RAND = new Random();
    private static final int MIN_BID = 1_000;
    private static final int MAXBID = 10_000;

    public static void main(String[] args) {

        AuctionMediator auctionGroup = new AuctionMediator();

        Buyer jason = new AuctionBuyer(auctionGroup, "Jason");
        Buyer ian = new AuctionBuyer(auctionGroup, "Ian");
        Buyer myra = new AuctionBuyer(auctionGroup, "Myra");

        System.out.println("---------------------------------------------");
        System.out.println("Welcome to the auction. Please Bid your offers.");
        System.out.println("---------------------------------------------");

        // Making bids
        jason.bid(RAND.nextInt(MAXBID - MIN_BID) + MIN_BID);
        ian.bid(RAND.nextInt(MAXBID - MIN_BID) + MIN_BID);
        myra.bid(RAND.nextInt(MAXBID - MIN_BID) + MIN_BID);

        auctionGroup.findWinner().ifPresent(winner -> {
            jason.notifyWinner(winner);
            ian.notifyWinner(winner);
            myra.notifyWinner(winner);
        });

        ian.cancelBid();

        auctionGroup.findWinner().ifPresent(winner -> {
            jason.notifyWinner(winner);
            myra.notifyWinner(winner);
        });
    }
}
