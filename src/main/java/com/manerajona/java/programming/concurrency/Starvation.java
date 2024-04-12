package com.manerajona.java.programming.concurrency;

import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Starvation {
    private static ReentrantLock lock = new ReentrantLock(true); // Fair true means: First-come, First-serve

    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_YELLOW), "Priority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");

        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        t5.start();
        t4.start();
        t3.start();
        t2.start();
        t1.start();

    }

    private static class Worker implements Runnable {
        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            IntStream.range(0, 50).forEach(i -> {
                // IMPORTANT: Fair locks impact in the performance!!
                lock.lock();
                try {
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                } finally {
                    lock.unlock();
                }
            });
        }
    }
}
