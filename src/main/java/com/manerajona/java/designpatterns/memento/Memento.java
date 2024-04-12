package com.manerajona.java.designpatterns.memento;

class MementoDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);
        Memento snapshot_1 = account.deposit(50); // 150
        Memento snapshot_2 = account.deposit(25); // 175
        System.out.println(account);
        System.out.println(account.getLastSnapshot().balance);

        // restore to m1
        account.restore(snapshot_1);
        System.out.println(account);

        // restore to m2
        account.restore(snapshot_2);
        System.out.println(account);
    }
}

class Memento {
    public int balance;

    public Memento(int balance) {
        this.balance = balance;
    }
}

class BankAccount {
    private int balance;
    private Memento last_snapshot;

    public BankAccount(int balance) {
        this.balance = balance;
        this.last_snapshot = new Memento(balance);
    }

    public Memento deposit(int amount) {
        balance += amount;
        last_snapshot = new Memento(balance);
        return last_snapshot;
    }

    public void restore(Memento m) {
        balance = m.balance;
        last_snapshot = new Memento(balance);
    }

    public Memento getLastSnapshot() {
        return last_snapshot;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }
}
