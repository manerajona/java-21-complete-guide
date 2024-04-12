package com.manerajona.java.programming.io.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOMain {

    public static final String DATA_DAT = "src/com/manerajona/java/programming/io/nio/data.dat";

    public static void main(String[] args) {

        try (FileOutputStream binFile = new FileOutputStream(DATA_DAT);
             FileChannel binChannel = binFile.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(100);

            byte[] outputBytes = "Hello World!".getBytes();
            buffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            buffer.putInt(245);
            long int2Pos = int1Pos + Integer.BYTES;
            buffer.putInt(-98765);
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
            buffer.putInt(1000);
            buffer.flip();

            binChannel.write(buffer);

            RandomAccessFile ra = new RandomAccessFile(DATA_DAT, "rwd");
            FileChannel channel = ra.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.read(readBuffer);
            readBuffer.flip();
            byte[] inputString = new byte[outputBytes.length];
            readBuffer.get(inputString);
            System.out.println("inputString = " + new String(inputString));
            System.out.println("int1 = " + readBuffer.getInt());
            System.out.println("int2 = " + readBuffer.getInt());
            byte[] inputString2 = new byte[outputBytes2.length];
            readBuffer.get(inputString2);
            System.out.println("inputString2 = " + new String(inputString2));
            System.out.println("int3 = " + readBuffer.getInt());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args) {
	    try {
            Path dataPath = getDefault().getPath("src/com/manerajona/java/programming/io/nio/data.txt");
            write(dataPath, "\nLine 6".getBytes("UTF-8"), StandardOpenOption.APPEND);
            List<String> lines = readAllLines(dataPath);
            lines.forEach(System.out::println);
        } catch(IOException e) {
	        e.printStackTrace();
        }
    }*/
}
