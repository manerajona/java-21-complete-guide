package com.manerajona.java.designpatterns.behavioral.strategy.example1;

public class Client {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("1234", 10));
        cart.addItem(new Item("5678", 40));

        // pay by paypal
        cart.pay(new PaypalStrategy("jason@email.com", "mypassword"));

        // pay by credit card
        cart.pay(new CreditCardStrategy("jason fedin", "2222222222222", "444", "12/15"));
    }
}
