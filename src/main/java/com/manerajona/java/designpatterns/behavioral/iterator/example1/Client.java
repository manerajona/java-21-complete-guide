package com.manerajona.java.designpatterns.behavioral.iterator.example1;

import java.util.stream.IntStream;

public class Client {

    public static void main(String[] args) {

        NotificationCollection notifications = new NotificationCollection(10);
        IntStream.rangeClosed(1, 5).forEach(i -> notifications.addNotification("Notification " + i));

        NotificationIterator iterator = (NotificationIterator) notifications.iterator();
        System.out.println("-------NOTIFICATIONS------------");
        while (iterator.hasNext()) {
            String message = iterator.next().message();
            System.out.println("[" + iterator.position() +"] " +message);
        }
    }
}
