package com.rakib.web_socket_java.client;

import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 80);
        System.out.println("Connected");
        new Listener(socket);
    }

}

class Listener implements Runnable {
    private final Socket socket;

    public Listener(Socket socket) throws IOException {
        this.socket = socket;
        DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        outputStream.writeUTF("name:Rakib");
        outputStream.flush();
        System.out.println("Send Success.");
        run();

    }

    @Override
    public void run() {
        while (true) {
            try {
                DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                System.out.println(dataInputStream.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}