package com.shakal.rpg.api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakal.rpg.api.dto.filter.ChallengeDificultInputDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;

@Controller
@CrossOrigin
@RestController
@RequestMapping("/combat")
public class CombatController {
	
	private static final String SENDING_URL = "/topic/room";
    private static final String RECEIVING_URL = "/server-receiver";
	
	private final SimpMessagingTemplate template;
	
	@Autowired
    public CombatController(SimpMessagingTemplate template) {
        this.template = template;
    }
	
	
	@PostMapping(value="/dificuldade",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> calculateChallengeDeficult(@RequestBody ChallengeDificultInputDTO inputDto) throws ResourceNotFoundException{
		return new ResponseEntity<String>("hard", HttpStatus.OK);
    }
	
	@MessageMapping(RECEIVING_URL)
    public void onReceivedMessage(String message) {
        System.out.println("New message received : " + message);
    }

	@SubscribeMapping(SENDING_URL)
    public String onSubscribe() {
        return "SUBSCRIBED";
    }
	@Scheduled(fixedRate = 1000)
    public void sendMessage() {
        template.convertAndSend(SENDING_URL, "Mail motherfucker");
    }
}
