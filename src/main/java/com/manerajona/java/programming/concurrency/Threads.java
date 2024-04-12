package com.manerajona.java.programming.concurrency;

public class Threads {

    // PROCESS: unit of execution that has its own memory space
    // HEAP: each process own memory space
    // THREAD: unit of execution within process
    // THREAD STACK: memory that threads can only read

    public static void main(String[] args) {

        // Thread
        AnotherThread at = new AnotherThread();
        //at.start();

        //new AnotherThread().start();

        new Thread(new Thread() {
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from anonymous thread");
            }
        }).start();

        // Runnable
        //new Thread(new MyRunnable()).start();

        new Thread(() -> {
            System.out.println(ThreadColor.ANSI_RED + "Hello from anonymous runnable");
            try {
                // Concatenate threads
                at.join();
                System.out.println(ThreadColor.ANSI_RED + "Another Thread terminated or timed out, so I'm running again");
            } catch (InterruptedException e) {
                System.out.println(ThreadColor.ANSI_RED + "I was interrupted");
            }
        }).start();

        // Multi-Thread

        Countdown countdown = new Countdown();

        CountDownThread countDownThread1 = new CountDownThread(countdown);
        countDownThread1.setName("Thread 1");
        CountDownThread countDownThread2 = new CountDownThread(countdown);
        countDownThread2.setName("Thread 2");

        //countDownThread1.start();
        //countDownThread2.start();

        // Race Condition

        countDownThread1.start();
        countDownThread2.start();
    }
}

class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_BLUE + "Hello from another thread");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(ThreadColor.ANSI_BLUE + "Another thread woke me up");
            return; // It terminate the thread
        }
        System.out.println(ThreadColor.ANSI_BLUE + "Two seconds passed");
    }

    @Override
    public synchronized void start() {
        super.start();
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_BLACK + "Hello from class runnable");
    }
}

class Countdown {

    public void doCountdown() {
        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        synchronized (this) {
            for (int i = 10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + ": i =" + i);
            }
        }
    }
}

class CountDownThread extends Thread {
    private Countdown countdown;

    public CountDownThread(Countdown countdown) {
        this.countdown = countdown;
    }

    public void run() {
        countdown.doCountdown();
    }
}
