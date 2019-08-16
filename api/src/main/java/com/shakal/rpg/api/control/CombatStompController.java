package com.shakal.rpg.api.control;



import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakal.rpg.api.contracts.service.ICombatService;
import com.shakal.rpg.api.dto.filter.CombatStateDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;



@Controller

public class CombatStompController {

	private HashMap<Long,CombatStateDTO> combats;
	private final SimpMessagingTemplate template;
	private ICombatService combatService;
	
	@Autowired
	public CombatStompController(SimpMessagingTemplate simpMessagingTemplate,
			ICombatService combatService) {
	        this.template = simpMessagingTemplate;
	        this.combatService = combatService;
	        this.combats = new HashMap<Long, CombatStateDTO>();
	}
	
	@MessageMapping("/combat/{id}")
	public void recieveDTO(@DestinationVariable Long id,CombatStateDTO state) throws Exception {
		//state.setDificult(combatService.calculateChallengeDeficult(state));
		state = this.combatService.updateMonstersConditions(state);
		combats.put(Long.valueOf(id), this.combatService.updateMonstersConditions(state));
		this.template.convertAndSend("/topic/combat/"+ id, state);
	     
	}
	
	
	 
}
