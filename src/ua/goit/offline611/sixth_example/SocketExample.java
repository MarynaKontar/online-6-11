package ua.goit.offline611.sixth_example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by andreymi on 4/12/2017.
 */
public class SocketExample {
    public static void main(String[] args) {
        // java.net
        try {
            Socket socket = new Socket("www.google.com", 80);
            //
            // Send HTTP GET.
            //
            try (BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))) {
                bufferedReader.lines().forEach(System.out::println);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
