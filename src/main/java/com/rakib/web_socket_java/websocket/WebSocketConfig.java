package com.rakib.web_socket_java.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    public final static String CHAT_END_POINT = "/text";
    public final static String FILE_END_POINT = "/file";

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry
                .addHandler(handlerText(), CHAT_END_POINT)
                .setAllowedOrigins("*");
        webSocketHandlerRegistry
                .addHandler(handlerBinary(), FILE_END_POINT)
                .setAllowedOrigins("*");
    }

    @Bean
    public HandlerText handlerText() {
        return new HandlerText();
    }

    @Bean
    public HandlerBinary handlerBinary() {
        return new HandlerBinary();
    }
}
