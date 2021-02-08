package com.rakib.web_socket_java.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    public final static String CHAT_END_POINT = "/chat";
    public final static String ALL_END_POINT = "/all";
    public final static String GROUP_END_POINT = "/group";

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry
                .addHandler(getWebSocketHandler(), CHAT_END_POINT)
                .setAllowedOrigins("*");
        webSocketHandlerRegistry
                .addHandler(getWebSocketHandler(), GROUP_END_POINT)
                .setAllowedOrigins("*");
        webSocketHandlerRegistry
                .addHandler(getWebSocketHandlerForAllUser(), ALL_END_POINT)
                .setAllowedOrigins("*");
    }

    @Bean
    public WebSocketHandler getWebSocketHandler() {
        return new WebSocketHandler();
    }

    @Bean
    public WebSocketHandlerForAllUser getWebSocketHandlerForAllUser() {
        return new WebSocketHandlerForAllUser();
    }
}
