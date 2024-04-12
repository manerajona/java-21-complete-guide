package com.manerajona.java.programming.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPURLConn {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.org/notfound");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");
            connection.setReadTimeout(30000);

            int responseCode ;
            if((responseCode = connection.getResponseCode()) != 200) {
                System.out.printf("Error code %d reading web page. Message; %s\n", responseCode, connection.getResponseMessage());
                return;
            }

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            String line;
            while((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }
            inputReader.close();

        } catch(MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
