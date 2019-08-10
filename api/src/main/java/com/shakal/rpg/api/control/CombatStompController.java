package com.shakal.rpg.api.control;



import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.shakal.rpg.api.contracts.service.ICombatService;
import com.shakal.rpg.api.dto.filter.CombatStateDTO;



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
		System.out.println("Número da História: " +id);
		state = this.combatService.updateMonstersConditions(state);
		combats.put(Long.valueOf(id), this.combatService.updateMonstersConditions(state));
		this.template.convertAndSend("/topic/combat/"+ id, state);
	     
	}
	 
}
