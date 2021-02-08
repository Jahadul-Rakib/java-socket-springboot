package com.rakib.web_socket_java.socket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@SpringBootApplication
public class WebSocketJavaApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(WebSocketJavaApplication.class, args);
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Socket accept = socket.accept();
            new ClientHandler(accept);
        }

    }

}
