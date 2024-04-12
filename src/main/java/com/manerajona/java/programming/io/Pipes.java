package com.manerajona.java.programming.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class Pipes {

    public static void main(String[] args) {
        try {
            Pipe pipe = Pipe.open();

            Runnable writer = writer(pipe);
            Runnable reader = reader(pipe);

            new Thread(writer).start();
            new Thread(reader).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Runnable writer(Pipe pipe) {
        return () -> {
            try {
                Pipe.SinkChannel sinkChannel = pipe.sink();
                ByteBuffer buffer = ByteBuffer.allocate(56);

                for (int i = 0; i < 10; i++) {
                    String currentTime = "The time is: " + System.currentTimeMillis();

                    buffer.put(currentTime.getBytes());
                    buffer.flip();

                    while (buffer.hasRemaining()) {
                        sinkChannel.write(buffer);
                    }
                    buffer.flip();
                    Thread.sleep(100);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    private static Runnable reader(Pipe pipe) {
        return () -> {
            try {
                Pipe.SourceChannel sourceChannel = pipe.source();
                ByteBuffer buffer = ByteBuffer.allocate(56);

                for (int i = 0; i < 10; i++) {
                    int bytesRead = sourceChannel.read(buffer);
                    byte[] timeString = new byte[bytesRead];
                    buffer.flip();
                    buffer.get(timeString);
                    System.out.println("Reader Thread: " + new String(timeString));
                    buffer.flip();
                    Thread.sleep(100);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
