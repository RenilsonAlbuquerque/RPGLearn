package com.shakal.rpg.api.websocket;

import java.io.IOException;


import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ImageWebsocket extends BinaryWebSocketHandler {
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) {
		
	}

}
