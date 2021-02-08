package com.rakib.web_socket_java.socket;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

@RestController(value = "/")
public class BaseController {

    @PostMapping("post")
    public void postMessage(@RequestParam("name") String name, @RequestParam("data") String data) throws IOException {
        Map<String, Socket> socketMap = ClientHandler.socketMap;
        if (socketMap.containsKey(name)) {
            Socket socket = socketMap.get(name);
            ClientHandler.sendData(socket, data);
        } else
            throw new FileNotFoundException("Not Found Name");

    }
}
