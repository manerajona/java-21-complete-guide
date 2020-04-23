package com.manerajona.java.programming.junit

import spock.lang.Specification

class BankAccountSpockTest extends Specification {

    BankAccount account = new BankAccount("Jona", "Manera", 1000.00, BankAccount.CHECKING)

    def "Deposit"() {
        given:
        final def amount = 200.00

        when:
        def balance = account.deposit(amount, true)

        then:
        balance == (double) 1200.00
        account.getBalance() == (double) 1200.00
    }

    def "Withdraw"() {
        given:
        final def amount = 200.00

        when:
        def balance = account.withdraw(amount, true)

        then:
        balance == (double) 800.00
        account.getBalance() == (double) 800.00
    }

    def "Withdraw should throw IllegalArgumentException"() {
        given:
        final def amount = 600.00

        when:
        account.withdraw(amount, false)

        then:
        thrown(IllegalArgumentException)
        account.getBalance() == (double) 1000.00
    }

    def "GetBalance"() {
        expect:
        account.getBalance() == (double) 1000.00
    }

    def "isChecking eq true"() {
        expect:
        account.isChecking()
    }

    def "Dummy Test"() {
        def i = 1 + 1
        expect:
        i == 2
    }

}
