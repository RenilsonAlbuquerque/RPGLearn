package com.shakal.rpg.api.websocket.stomp;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
/*
@EnableWebSocket
@Configuration
@EnableWebSocketMessageBroker
*/
public class WebSocketConfig 
//implements WebSocketMessageBrokerConfigurer 
{
	/*
	@Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic/", "/queue/");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").addInterceptors(new HttpHandshakeInterceptor()).setAllowedOrigins("http://localhost:3000").withSockJS();
    }
    */
}