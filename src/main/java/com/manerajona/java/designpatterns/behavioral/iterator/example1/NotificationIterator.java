package com.manerajona.java.designpatterns.behavioral.iterator.example1;

import java.util.Iterator;
import java.util.NoSuchElementException;

class NotificationIterator implements Iterator<Notification> {

    private final Notification[] notificationList;

    private int position;

    public NotificationIterator(Notification[] notificationList) {
        this.notificationList = notificationList;
    }

    @Override
    public Notification next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return notificationList[position++];
    }

    @Override
    public boolean hasNext() {
        return position < notificationList.length && notificationList[position] != null;
    }

    public int position() {
        return this.position;
    }
}
