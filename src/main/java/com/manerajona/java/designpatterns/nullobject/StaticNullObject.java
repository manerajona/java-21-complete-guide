package com.manerajona.java.designpatterns.nullobject;

import java.text.MessageFormat;

class  NullObject {
    public static void main(String[] args) {
        //ConsoleLog log = new ConsoleLog();
        //Log log = null;
        NullLog log = new NullLog();

        BankAccount ba = new BankAccount(log);
        ba.deposit(100);
        ba.withdraw(200);
    }
}

interface Log {

    void info(String msg);

    void warn(String msg);
}

class ConsoleLog implements Log {

    @Override
    public void info(String msg) {
        System.out.println(msg);
    }

    @Override
    public void warn(String msg) {
        System.out.println("WARNING: " + msg);
    }
}

class BankAccount {

    private Log log;
    private int balance;

    public BankAccount(Log log) {
        this.log = log;
    }

    public void deposit(int amount) {
        balance += amount;

        // check for null everywhere?
        if (log != null) {
            log.info(MessageFormat.format("Deposited {0}, balance is now {1}", amount, balance));
        }
    }

    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            if (log != null) {
                System.out.printf("Withdrew %d, we have %d left%n", amount, balance);
            }
        } else {
            if (log != null) {
                System.out.printf("Could not withdraw %d because balance is only %d%n", amount, balance);
            }
        }
    }
}

final class NullLog implements Log {

    @Override
    public void info(String msg) {
    }

    @Override
    public void warn(String msg) {
    }
}
