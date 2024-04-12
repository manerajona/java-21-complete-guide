package com.manerajona.java.programming.concurrency;

public class DeadLock {

    public static void main(String[] args) {
        // Case 1
        new DeadLockBasic().execute();

        // Case 2
        final PolitePerson jane = new PolitePerson("Jane");
        final PolitePerson john = new PolitePerson("John");

        new Thread(() -> jane.sayHello(john)).start();
        new Thread(() -> john.sayHello(jane)).start();
    }

    public static class DeadLockBasic {
        public static final Object lock1 = new Object();
        public static final Object lock2 = new Object();

        public void execute() {
            new Thread(this::processThis).start();
            new Thread(this::processThat).start();
        }

        private void processThis() {
        synchronized (lock1) {
            System.out.println("Thread 1: Has lock1");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {

            }
            System.out.println("Thread 1: Waiting for lock2");
            synchronized (lock2) {
                System.out.println("Thread 1: Has lock1 and lock2");
            }
            System.out.println("Thread 1: Released lock2");
        }
        System.out.println("Thread 1: Released lock1. Exiting...");
    }

    private void processThat() {
        synchronized (lock2) {
            System.out.println("Thread 2: Has lock1");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {

            }
            System.out.println("Thread 2: Waiting for lock2");
            synchronized (lock1) {
                System.out.println("Thread 2: Has lock1 and lock2");
            }
            System.out.println("Thread 2: released lock2");
        }
        System.out.println("Thread 2: Released lock1. Exiting...");
    }
    }

    // 1. Thread1 acquires the lock on the jane object and enters the sayHello() method.
    // It prints to the console, then suspends.
    // 2. Thread2 acquires the lock on the john object and enters the sayHello() method.
    // It prints to the console, then suspends.
    // 3. Thread1 runs again and wants to say hello back to the john object. It tries to call the sayHelloBack() method
    // using the john object that was passed into the sayHello() method,
    // but Thread2 is holding the john lock, so Thread1 suspends.
    // 4. Thread2 runs again and wants to say hello back to the jane object. It tries to call the sayHelloBack() method
    // using the jane object that was passed into the sayHello() method,
    // but Thread1 is holding the jane lock, so Thread2 suspends.

    static class PolitePerson {
        private final String name;

        public PolitePerson(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void sayHello(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello to me!%n", this.name, person.getName());
            person.sayHelloBack(this);
        }

        public synchronized void sayHelloBack(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello back to me!%n", this.name, person.getName());
        }
    }
}
