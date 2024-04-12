package com.manerajona.java.programming.concurrency;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.manerajona.java.programming.concurrency.MyConsumer.EOF;

public class ThreadPools {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);

        final int numOfThreads = 5;

        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);

        Producer producer = new Producer(buffer, ThreadColor.ANSI_YELLOW);
        Consumer consumer1 = new Consumer(buffer, ThreadColor.ANSI_PURPLE);
        Consumer consumer2 = new Consumer(buffer, ThreadColor.ANSI_CYAN);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        // Callable
        Future<String> future = executorService.submit(() -> {
            System.out.println(ThreadColor.ANSI_WHITE + "I'm being printed for the Callable class");
            return "This is the callable result";
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread running the task was interrupted");
        }

        // Orderly shutdown
        executorService.shutdown();
    }
}

class Producer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public Producer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        Random random = new Random();
        String[] nums = { "1", "2", "3", "4", "5"};

        for(String num: nums) {
            try {
                System.out.println(color + "Adding..." + num);
                // Is a thread safe method, is automatically locked
                buffer.put(num);

                Thread.sleep(random.nextInt(1000));
            } catch(InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        try {
            buffer.put("EOF");
        } catch(InterruptedException ignored) {
        }
    }
}

class Consumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public Consumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {

        while(true) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }

                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException ignored) {

                }
            }
        }
    }
}
