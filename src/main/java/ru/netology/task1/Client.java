package ru.netology.task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        try (
                Socket clientSocket = new Socket(host, Server.PORT);
                PrintWriter out = new
                        PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new
                        InputStreamReader(clientSocket.getInputStream()))
        ) {
            out.println("GET / HTTP/1.1\n" +
                    "Host: localhost\n\n\n");
            String resp = in.readLine();
            System.out.println(resp);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
