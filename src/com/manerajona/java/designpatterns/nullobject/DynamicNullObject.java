package com.manerajona.java.designpatterns.nullobject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.text.MessageFormat;

class Demo {

    public static final InvocationHandler INVOCATION_HANDLER = (proxy, method, args) -> {
        // Dynamic proxy
        if (method.getReturnType().equals(Void.TYPE)) { // void methods return null
            return null;
        } else {
            return method.getReturnType().getConstructor().newInstance();
        }
    };

    @SuppressWarnings("unchecked")
    public static <T> T noOp(Class<T> itf) {
        return (T) Proxy.newProxyInstance(
                itf.getClassLoader(),
                new Class<?>[]{itf},
                INVOCATION_HANDLER);
    }

    public static void main(String[] args) {

        //NullLog log = new NullLog();
        Log log = noOp(Log.class);

        BankAccount1 ba = new BankAccount1(log);
        ba.deposit(100);
        ba.withdraw(200);
    }
}

class BankAccount1 {
    private Log log;
    private int balance;

    public BankAccount1(Log log) {
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
                log.info(MessageFormat.format("Withdrew {0}, we have {1} left", amount, balance));
            }
        } else {
            if (log != null) {
                log.warn(MessageFormat.format("Could not withdraw {0} because balance is only {1}", amount, balance));
            }
        }
    }
}