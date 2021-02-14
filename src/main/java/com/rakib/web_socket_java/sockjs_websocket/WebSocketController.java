package com.rakib.web_socket_java.sockjs_websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

    @MessageMapping("/chatting")
    @SendTo(Constant.TOPIC_SAMPLE+"/general")
    public String publishMessage(String message) {
        return message;
    }
}
