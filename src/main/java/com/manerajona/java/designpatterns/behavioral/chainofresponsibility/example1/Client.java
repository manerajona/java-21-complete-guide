package com.manerajona.java.designpatterns.behavioral.chainofresponsibility.example1;

import java.util.Scanner;

public class Client {

    private final DispenseChain dispenseChain;

    Client() {
        // initialize the chain
        this.dispenseChain = new Dollar50DispenseImpl();
        DispenseChain dollar20Dispenser = new Dollar20DispenseImpl();
        DispenseChain dollar10Dispenser = new Dollar10DispenseImpl();

        // set the chain of responsibility
        dispenseChain.setNextChain(dollar20Dispenser);
        dollar20Dispenser.setNextChain(dollar10Dispenser);
    }

    public static void main(String[] args) {
        System.out.println("Enter amount to dispense");
        Scanner input = new Scanner(System.in);
        int amount = input.nextInt();

        if (amount <= 0 || amount % 10 != 0) {
            System.out.println("Amount should be in multiple of 10s.");
            return;
        }

        // process the request
        new Client().dispenseChain.dispense(new Currency(amount));
    }
}
