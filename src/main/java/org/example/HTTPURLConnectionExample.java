package org.example;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class HTTPURLConnectionExample {
    public static void main(String[] args) throws Exception{
        URL url = new URL("https://www.youtube.com");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        System.out.println("Expired date: "+ new Date(connection.getExpiration()));

        System.out.println("last: "+ connection.getLastModified());
        System.out.println("doc date: "+ new Date(connection.getDate()));

        System.out.println("content-type: " + connection.getContentType());
        System.out.println("content length: "+ connection.getContentLength());
        System.out.println("response code: "+ connection.getResponseCode());
    }
}
