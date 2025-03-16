package com.manerajona.java.designpatterns.behavioral.chainofresponsibility.example2;

record IssueRaiser(ReceiverInterface receiver) {

    public void raiseMessage(Message msg) {
        receiver.process(msg);
    }
}
