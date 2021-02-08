package com.rakib.web_socket_java.socket;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientHandler {
    public static Map<String, Socket> socketMap = new HashMap<>();
    public Socket socket;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        DataInputStream inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        String readUTF = inputStream.readUTF();
        if (readUTF.contains("name")) {
            String[] split = readUTF.split(":");
            String userName = split[1];
            if (socketMap.containsKey(userName)) {
                socketMap.replace(userName, socket);
            } else {
                socketMap.put(userName, socket);
            }
            System.out.println(userName);
        }
    }

    public static void sendData(Socket socket, String message) throws IOException {
        DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        outputStream.writeUTF(message);
        outputStream.flush();
    }
}
