package ru.dankras.MyDemoServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) {
        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());//Так ответ отправляется
            // OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream()); /а так нет
            // PrintWriter out=new PrintWriter(socket.getOutputStream());и так тоже
            while (true) {
                String str = in.readLine();
                if (str != null) {
                    System.out.println(str);
                }
                if (str.equals("/end")) {
                    break;
                }
                out.writeUTF("Эхо: " + str);
                // out.write("Эхо: " + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
