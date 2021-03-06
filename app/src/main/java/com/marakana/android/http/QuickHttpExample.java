package com.marakana.android.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
public class QuickHttpExample {
    public static void main(String[] args) {
        HttpURLConnection urlConnection = null;
        try {
            URL url =
                    new URL(
                            "http://yamba.marakana.com/api/statuses/public_timeline.json");
            urlConnection = (HttpURLConnection) url.openConnection();
            int statusCode = urlConnection.getResponseCode(); //check response status
            System.out.println("Response Code: "+statusCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream())); // read in the server's output
            String textline = null;
            while((textline = in.readLine()) != null) {
                System.out.println(textline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(urlConnection != null) urlConnection.disconnect(); // terminate connection
        }
    }
}