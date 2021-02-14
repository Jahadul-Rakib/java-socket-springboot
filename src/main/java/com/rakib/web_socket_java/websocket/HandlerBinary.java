package com.rakib.web_socket_java.websocket;

import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

import static com.rakib.web_socket_java.websocket.Constants.WEB_SOCKET_SESSION;

public class HandlerBinary extends BinaryWebSocketHandler {
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        WEB_SOCKET_SESSION.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        WEB_SOCKET_SESSION.remove(session);
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
        super.handleBinaryMessage(session, message);
    }

}
