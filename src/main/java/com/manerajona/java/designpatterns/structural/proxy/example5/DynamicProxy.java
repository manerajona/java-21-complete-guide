package com.manerajona.java.designpatterns.structural.proxy.example5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

class LoggingHandler implements InvocationHandler {
    private final Object target;
    private final Map<String, Integer> calls = new HashMap<>();

    LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();

        if (name.contains("toString")) {
            return calls.toString();
        }
        // add or increment number of calls
        calls.merge(name, 1, Integer::sum);
        return method.invoke(target, args);
    }
}

interface Human {
    void walk();
    void talk();
}

class Person implements Human {
    @Override
    public void walk() {
        System.out.println("I am walking");
    }

    @Override
    public void talk() {
        System.out.println("I am talking");
    }
}