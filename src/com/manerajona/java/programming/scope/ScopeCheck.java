package com.manerajona.java.programming.scope;

import java.util.stream.IntStream;

public class ScopeCheck {

    public int publicVar = 1;
    private int privateVar = 2;

    public ScopeCheck() {
        System.out.printf("ScopeCheck created with public var %d and private var %d\n", publicVar, privateVar);
    }

    public int getPrivateVar() {
        return privateVar;
    }

    public void timesTwo() {
        IntStream.range(0, 10).forEach(privateVar -> {
            int two = this.privateVar;
            System.out.println("Private var in this scope is " + this.privateVar);
            System.out.println(privateVar + " times two is " + privateVar * two);
            System.out.println("Private var in this scope is " + privateVar);
        });
        int privateVar = 123456789;
        System.out.println("Private var in this scope is " + privateVar);
    }

    public class InnerClassScope {
        private int privateVar=99;

        public int getPrivateVar() {
            return privateVar;
        }
    }

    public static void main(String[] args) {
        String privateVar = "This is private to main()";
        System.out.println(privateVar);

        ScopeCheck scopeCheck = new ScopeCheck();
        System.out.println("This is private to scopeCheck "+scopeCheck.getPrivateVar());
        System.out.println("This is public to scopeCheck "+scopeCheck.publicVar);
        scopeCheck.timesTwo();

        ScopeCheck.InnerClassScope innerClassScope = scopeCheck.new InnerClassScope();
        System.out.println("This is private to scopeCheck.innerClassScope "+innerClassScope.getPrivateVar());

    }
}
