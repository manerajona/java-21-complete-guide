package com.manerajona.java.designpatterns.behavioral.observer.example1;

interface Observer {

    void getUpdates();

    String routingKey();
}

class NotificationObserver implements Observer {
    private final String category;
    private final Subject<Notification> topic;

    public NotificationObserver(String category, Subject<Notification> topic) {
        this.category = category;
        this.topic = topic;
    }

    @Override
    public void getUpdates() {
        topic.pull(this).forEach(notification ->
                System.out.printf("%s: %s%n", category, notification.headline()));
    }

    @Override
    public String routingKey() {
        return this.category;
    }
}