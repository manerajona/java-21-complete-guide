package com.manerajona.java.programming.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while (true) new Echoer(serverSocket.accept()).start();
        } catch (IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }
}

class Echoer extends Thread {
    private Socket socket;

    public Echoer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String echoString;
            do {
                echoString = input.readLine().toUpperCase();
                System.out.println("Received client input: " + echoString);
                /*try {
                    Thread.sleep(15000);
                } catch(InterruptedException e) {
                    System.out.println("Thread interrupted");
                }*/
                output.println(echoString);
            } while (!echoString.equals("EXIT"));

        } catch (IOException e) {
            System.out.println("Oops: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                // Oh, well!
            }
        }
    }
}