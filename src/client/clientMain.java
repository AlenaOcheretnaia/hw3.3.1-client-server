package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class clientMain {
    public static void main(String[] args) {

        String host = "127.0.0.1";
        int port = 8086;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(clientSocket.getInputStream()))) {

            //Читаем строку и выводим её на экран вместе с номером порта клиента, с которого пришло соединение

            out.println("This is message from client: AlOch netology.ru");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
