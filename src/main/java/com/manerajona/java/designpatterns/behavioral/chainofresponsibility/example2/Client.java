package com.manerajona.java.designpatterns.behavioral.chainofresponsibility.example2;

public class Client {
    public static void main(String[] args) {
        ReceiverInterface emailHandler = new EmailErrorHandler();
        ReceiverInterface faxHandler = new FaxErrorHandler();
        faxHandler.next(emailHandler);

        // starting point: raiser will raise issues and set the first handler
        IssueRaiser raiser = new IssueRaiser(faxHandler);

        Message m1 = new Message("Fax is reaching late to the destination", MessagePriority.NORMAL);
        Message m2 = new Message("Email is not going", MessagePriority.HIGH);
        Message m3 = new Message("In Email, BCC field is disabled occasionally", MessagePriority.NORMAL);
        Message m4 = new Message("Fax is not reaching destination", MessagePriority.HIGH);

        raiser.raiseMessage(m1);
        raiser.raiseMessage(m2);
        raiser.raiseMessage(m3);
        raiser.raiseMessage(m4);
    }
}
