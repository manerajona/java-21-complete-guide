package com.manerajona.java.designpatterns.behavioral.state.example2;

interface MobileAlertState {
    void alert();
}

class Vibration implements MobileAlertState {
    @Override
    public void alert() {
        System.out.println("vibration...");
    }
}

class Ring implements MobileAlertState {
    @Override
    public void alert() {
        System.out.println("ring...");
    }
}