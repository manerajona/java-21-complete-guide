package com.manerajona.java.programming.scope;

import com.manerajona.java.programming.scope.newnamespace.Account;

public class AccesModifiers {
    public static void main(String[] args) {
        /*Public, private, protected, package, default*/
        Account account = new Account("Jona account");
        account.deposit(5000);
        account.withdraw(100);
        account.withdraw(-200);
        account.deposit(-20);
        account.calculateBalance();

        /* Static */
        StaticClass sc1 = StaticClass.getInstance();
        System.out.println(StaticClass.getInstanceCounter());
        System.out.println(sc1.instanceNumber);
        StaticClass sc2 = StaticClass.getInstance();
        System.out.println(StaticClass.getInstanceCounter());
        System.out.println(sc2.instanceNumber);
        StaticClass sc3 = StaticClass.getInstance();
        System.out.println(StaticClass.getInstanceCounter());
        System.out.println(sc3.instanceNumber);
    }
}
