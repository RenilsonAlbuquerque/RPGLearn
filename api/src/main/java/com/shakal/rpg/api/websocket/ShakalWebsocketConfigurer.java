package com.shakal.rpg.api.websocket;

import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

public class ShakalWebsocketConfigurer implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //registry.addHandler(new MyTextHandler(), "/text").withSockJS();
        registry.addHandler(new ImageWebsocket(), "/image").withSockJS();
    }


}
