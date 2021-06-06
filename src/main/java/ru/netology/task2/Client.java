package ru.netology.task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        Scanner scanner = new Scanner(System.in);
        String answer;
        try (
                Socket clientSocket = new Socket(host, Server.PORT);
                PrintWriter out = new
                        PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new
                        InputStreamReader(clientSocket.getInputStream()))
        ) {
            String resp = in.readLine();
            System.out.println(resp);
            answer = scanner.nextLine();
            out.println(answer);

            resp = in.readLine();
            System.out.println(resp);
            answer = scanner.nextLine();
            out.println(answer);

            resp = in.readLine();
            System.out.println(resp);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
