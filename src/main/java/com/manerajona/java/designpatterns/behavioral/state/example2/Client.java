package com.manerajona.java.designpatterns.behavioral.state.example2;

public class Client {
    public static void main(String[] args) {
        AlertStateContext stateContext = new AlertStateContext(new Ring());
        stateContext.alert();
        stateContext.alert();

        stateContext.setState(new Vibration());
        stateContext.alert();
        stateContext.alert();
        stateContext.alert();
    }
}