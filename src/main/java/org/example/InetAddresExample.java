package org.example;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddresExample {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("www.google.com");
            System.out.println( "host "+ip.getHostName() );
            System.out.println(" ip "+ip.getHostAddress());

            InetAddress address[] = InetAddress.getAllByName("www.google.com");
            for (int i = 0; i < address.length; i++) {
                System.out.println("addr: "+address[i]);
            }
        }catch (UnknownHostException e){
            e.printStackTrace();
        }
    }
}
