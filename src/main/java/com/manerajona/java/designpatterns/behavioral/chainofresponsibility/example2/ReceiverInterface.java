package com.manerajona.java.designpatterns.behavioral.chainofresponsibility.example2;

interface ReceiverInterface {
    void process(Message msg);

    void next(ReceiverInterface nextChain);
}

class FaxErrorHandler implements ReceiverInterface {

    private ReceiverInterface nextReceiver;

    public void next(ReceiverInterface nextReceiver) {
        this.nextReceiver = nextReceiver;
    }

    public void process(Message msg) {
        if (msg.text().contains("Fax")) {
            System.out.println("FaxErrorHandler processed " + msg.priority() + "priority issue: " + msg.text());
        } else if (nextReceiver != null) {
            nextReceiver.process(msg);
        }
    }
}

class EmailErrorHandler implements ReceiverInterface {

    private ReceiverInterface nextReceiver;

    public void next(ReceiverInterface nextReceiver) {
        this.nextReceiver = nextReceiver;
    }

    public void process(Message msg) {
        if (msg.text().contains("Email")) {
            System.out.println("EmailErrorHandler processed " + msg.priority() + "priority issue: " + msg.text());
        } else if (nextReceiver != null) {
            nextReceiver.process(msg);
        }
    }
}



