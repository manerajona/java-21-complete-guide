package com.manerajona.java.designpatterns.behavioral.mediator.example1;

public class Client {
    public static void main(String[] args) {

        ChatMediator chatGroup = new ChatMediatorImpl();

        User user1 = new UserImpl(chatGroup, "Jason");
        User user2 = new UserImpl(chatGroup, "Jennifer");
        User user3 = new UserImpl(chatGroup, "Lucy");
        User user4 = new UserImpl(chatGroup, "Ian");

        System.out.println("---------------------------------------------");

        user1.send("Hi All!");
        user2.send("Hi Jason");
        user3.send("Hi Jason");
        user4.send("Hi Jason");
    }
}
