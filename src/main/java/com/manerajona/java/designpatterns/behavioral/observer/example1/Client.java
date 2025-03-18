package com.manerajona.java.designpatterns.behavioral.observer.example1;

public class Client {
    public static void main(String[] args) {
        NotificationSubject topic = new NotificationSubject();

        // Create observers
        Observer politics = new NotificationObserver("Politics", topic);
        Observer international = new NotificationObserver("International", topic);
        Observer sports = new NotificationObserver("Sports", topic);

        // Register observers to the topic
        topic.register(politics);
        topic.register(international);
        topic.register(sports);

        // send notifications
        topic.publish(new Notification("Most Americans are rooting for Ukraine.", politics.routingKey()));
        topic.publish(new Notification("Treasury Secretary says he's 'not at all' worried amid stock market sell-off.", politics.routingKey()));
        topic.publish(new Notification("Vatican releases first photo of Pope Francis since his hospitalization.", international.routingKey()));
        topic.publish(new Notification("Donatella Versace steps down as head of Italian fashion house", international.routingKey()));
        topic.publish(new Notification("France crowned Six Nations champions after inspired second-half surge breaks visitors' resistance.", sports.routingKey()));

        // remove observer
        topic.unregister(sports);

        // send sport notification
        topic.publish(new Notification("Rory McIlroy beats JJ Spaun in Monday play-off to claim PGA Tour win at TPC Sawgrass.", sports.routingKey()));

        // check any updates
        sports.getUpdates();
        topic.register(sports);
        sports.getUpdates();
    }
}
