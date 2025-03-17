package com.manerajona.java.designpatterns.behavioral.mediator.example1;

abstract class User {
    protected ChatMediator mediator;
    protected String name;

    protected User(ChatMediator med, String name) {
        this.mediator = med;
        this.name = name;
    }

    public abstract void send(String msg);

    public abstract void receive(String msg, User sender);
}

class UserImpl extends User {

    public UserImpl(ChatMediator chatGroup, String name) {
        super(chatGroup, name);

        // add user to chat group
        chatGroup.addUser(this);
    }

    @Override
    public void send(String msg) {
        mediator.broadcast(msg, this);
    }

    @Override
    public void receive(String msg, User sender) {
        System.out.printf("[%s] %s says '%s'%n", this.name, sender.name, msg);
    }
}