package org.example;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.net.URL;
import java.net.URLConnection;

public class URLConecctionExample {
    public static void main(String[] args) throws Exception{
        URL url = new URL("https://www.youtube.com");
        URLConnection urlConnection = url.openConnection();

        BufferedInputStream inputStream =
                new BufferedInputStream(urlConnection.getInputStream());
        int i = 0;
        while ((i = inputStream.read())!=-1){
            System.out.print((char)i );
        }
    }
}
