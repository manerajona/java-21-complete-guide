package com.manerajona.java.designpatterns.behavioral.chainofresponsibility.example1;

interface DispenseChain {
    void setNextChain(DispenseChain nextChain);

    void dispense(Currency cur);
}

class Dollar50DispenseImpl implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.amount() >= 50) {
            int num = cur.amount() / 50;
            System.out.println("Dispensing " + num + " x 50$");

            int remainder = cur.amount() % 50;
            if (remainder != 0) this.chain.dispense(new Currency(remainder));
        } else {
            this.chain.dispense(cur);
        }
    }
}

class Dollar20DispenseImpl implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.amount() >= 20) {
            int num = cur.amount() / 20;
            System.out.println("Dispensing " + num + " x 20$");

            int remainder = cur.amount() % 20;
            if (remainder != 0) this.chain.dispense(new Currency(remainder));
        } else {
            this.chain.dispense(cur);
        }
    }
}

class Dollar10DispenseImpl implements DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.amount() >= 10) {
            int num = cur.amount() / 10;
            System.out.println("Dispensing " + num + " x 10$");

            int remainder = cur.amount() % 10;
            if (remainder != 0) this.chain.dispense(new Currency(remainder));
        } else {
            this.chain.dispense(cur);
        }
    }
}