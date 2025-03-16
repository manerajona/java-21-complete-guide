package com.manerajona.java.designpatterns.behavioral.chainofresponsibility.example2;

enum MessagePriority {
    NORMAL,
    HIGH
}

record Message(String text, MessagePriority priority) {
}
