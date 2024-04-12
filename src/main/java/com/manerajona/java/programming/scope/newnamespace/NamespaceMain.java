package com.manerajona.java.programming.scope.newnamespace;

public class NamespaceMain {
    public static void main(String[] args) {
        Account account = new Account("Jona account");
        account.deposit(5000);
        account.withdraw(100);
        account.withdraw(-200);
        account.deposit(-20);
        account.calculateBalance();
        account.accountName = "Tim account";
    }
}
