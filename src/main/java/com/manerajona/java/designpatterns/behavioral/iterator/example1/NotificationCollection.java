package com.manerajona.java.designpatterns.behavioral.iterator.example1;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

class NotificationCollection implements Iterable<Notification> {

    private final int maxItems;
    private final Notification[] notifications;
    private int position;

    public NotificationCollection(int maxItems) {
        this.maxItems = maxItems;
        this.notifications = new Notification[maxItems];
    }

    public void addNotification(String message) {
        if (position < maxItems) {
            notifications[position++] = new Notification(message);
        } else {
            System.err.println("Maximum number of items exceeded");
        }
    }

    @Override
    public Iterator<Notification> iterator() {
        return new NotificationIterator(notifications);
    }

    @Override
    public void forEach(Consumer<? super Notification> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Notification> spliterator() {
        return Iterable.super.spliterator();
    }
}
