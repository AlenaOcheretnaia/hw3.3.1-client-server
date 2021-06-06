package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        //Запускаем сервер на определенном порту (8086) и принимаем соединение
        int port = 8086;
        while (true) {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept(); // ждем подключения
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("New connection accepted");

            //Читаем строку и выводим её на экран вместе с номером порта клиента, с которого пришло соединение
            final String message = in.readLine();
            System.out.println(String.format("%s; port is %d", message, clientSocket.getPort()));
            serverSocket.close();
        }
    }
}
