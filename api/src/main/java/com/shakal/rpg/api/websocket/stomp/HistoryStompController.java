package com.shakal.rpg.api.websocket.stomp;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HistoryStompController {

	
	  @MessageMapping("/chat")
	  @SendTo("/room")
	  public String greeting(String message) throws Exception {
	        Thread.sleep(1000); // simulated delay
	        String hello = "Hello how long";
	        System.out.println(hello);
	        return "Hello how long, when i slide";
	  }
}
