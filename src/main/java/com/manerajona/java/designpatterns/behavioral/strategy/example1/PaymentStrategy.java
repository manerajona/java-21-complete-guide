package com.manerajona.java.designpatterns.behavioral.strategy.example1;

interface PaymentStrategy {
    void pay(final int amount);
}

class CreditCardStrategy implements PaymentStrategy {
    private final String cardHolder;
    private final String cardNumber;
    private final String cvv;
    private final String expirationDate;

    public CreditCardStrategy(String cHolder, String cNumber, String cvv, String expiration) {
        this.cardHolder = cHolder;
        this.cardNumber = cNumber;
        this.cvv = cvv;
        this.expirationDate = expiration;
    }

    @Override
    public void pay(final int amount) {
        System.out.println(amount + "$ paid with credit/debit card");
    }
}

class PaypalStrategy implements PaymentStrategy {
    private final String alias;
    private final String password;

    public PaypalStrategy(String alias, String password) {
        this.alias = alias;
        this.password = password;
    }

    @Override
    public void pay(final int amount) {
        System.out.println(amount + "$ paid using Paypal.");
    }
}
