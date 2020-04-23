package com.manerajona.java.programming.scope.newnamespace;

import java.util.ArrayList;

public class Account {
    String accountName;
    private int balance = 0;
    private ArrayList<Integer> transactions;

    public Account(String accountName) {
        this.accountName = accountName;
        transactions = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            movement(amount);
        }
    }

    public void withdraw(int amount) {
        int withdraw = -amount;
        if (withdraw < 0) {
            movement(withdraw);
        }
    }

    private void movement(int amount) {
        transactions.add(amount);
        this.balance += amount;
        System.out.println("New balance " + balance);
    }

    public void calculateBalance() {
        this.balance = 0;
        transactions.forEach(i -> this.balance += i);
        System.out.println("Calculated balance is " + this.balance);
    }
}
