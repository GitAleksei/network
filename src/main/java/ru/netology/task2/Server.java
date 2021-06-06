package ru.netology.task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORT = 7873;

    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket(PORT);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in =
                        new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            System.out.println("New connection accept");
            out.println("Write your name");
            String name = in.readLine();

            out.println("How old are you?");
            int age = Integer.parseInt(in.readLine());

            User user = new User(name, age);

            if (user.isAdult()) {
                out.println("Welcome to the adult zone, " + user.getName() + "! Have a good rest, " +
                        "or a good working day!");
            } else {
                out.println("Welcome to the kids area, " + user.getName() + "! Let's play!");
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
