package com.manerajona.java.designpatterns.behavioral.mediator.example1;

import java.util.HashSet;
import java.util.Set;

interface ChatMediator {
    void broadcast(String msg, User sender);

    void addUser(User user);
}

class ChatMediatorImpl implements ChatMediator {

    private final Set<User> users;

    public ChatMediatorImpl() {
        this.users = new HashSet<>();
    }

    @Override
    public void addUser(User user) {
        System.out.printf("%s added to chat%n", user.name);
        this.users.add(user);
    }

    @Override
    public void broadcast(String msg, User sender) {
        // message should not be received by the user sending it
        this.users.stream()
                .filter(user -> user != sender)
                .forEach(user -> user.receive(msg, sender));
    }
}
