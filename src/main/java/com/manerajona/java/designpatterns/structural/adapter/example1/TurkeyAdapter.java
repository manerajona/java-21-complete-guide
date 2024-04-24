package com.manerajona.java.designpatterns.structural.adapter.example1;

import java.util.stream.IntStream;

class TurkeyAdapter implements Duck {

    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    public void quack() {
        turkey.gobble();
    }

    public void fly() {
        IntStream.range(0, 5).forEach(i -> turkey.fly());
    }
}