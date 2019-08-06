package com.shakal.rpg.api.websocket.stomp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.shakal.rpg.api.dto.filter.ChallengeDificultInputDTO;

@Controller
public class HistoryStompController {

	
	private final SimpMessagingTemplate template;
	
	@Autowired
	public HistoryStompController(SimpMessagingTemplate simpMessagingTemplate) {
	        this.template = simpMessagingTemplate;
	}
	
	  @MessageMapping("/combat")
	  @SendTo("/room")
	  public String greeting(String message) throws Exception {
	        Thread.sleep(1000); // simulated delay
	        ChallengeDificultInputDTO payload = new ChallengeDificultInputDTO();
	        payload.setChallengeLevel(3);
	        this.template.convertAndSend("/topic/combat", "uh fudeu");
	        return "Hello how long, when i slide";
	  }
	  @Scheduled(fixedRate = 1000)
	    public void sendMessage() {
	        template.convertAndSend("/app/combat", "Mail motherfucker");
	  }
}
