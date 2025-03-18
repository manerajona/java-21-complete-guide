package com.manerajona.java.designpatterns.behavioral.observer.example1;

import java.util.*;

interface Subject<T> {

    void register(Observer observer);

    void unregister(Observer observer);

    List<T> pull(Observer observer);

    void publish(T event);
}

class NotificationSubject implements Subject<Notification> {
    private final Set<Observer> observers;
    private final Deque<Notification> queue;

    public NotificationSubject() {
        this.observers = new HashSet<>();
        this.queue = new ArrayDeque<>();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public List<Notification> pull(Observer observer) {
        // Only process if the observer is registered
        if (!observers.contains(observer)) {
            return List.of();
        }
        List<Notification> observerNotifications = new ArrayList<>();

        // Remove notifications matching the observer's routing key
        queue.removeIf(notification -> {
            if (notification.category().equals(observer.routingKey())) {
                observerNotifications.add(notification);
                return true;
            }
            return false;
        });

        return observerNotifications;
    }

    @Override
    public void publish(Notification notification) {
        queue.offer(notification);

        // notify observers
        this.observers.forEach(Observer::getUpdates);
    }
}