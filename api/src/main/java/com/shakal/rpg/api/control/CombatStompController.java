package com.shakal.rpg.api.control;




import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;


import com.shakal.rpg.api.contracts.service.ICombatService;
import com.shakal.rpg.api.dto.combat.CombatStateDTO;
import com.shakal.rpg.api.dto.map.MapAreaDTO;



@Controller

public class CombatStompController {


	
	private ICombatService combatService;
	
	@Autowired
	public CombatStompController(
			ICombatService combatService) {
	        
	        this.combatService = combatService;
	}
	
	@MessageMapping("/combat/{id}")
	public void recieveDTO(@DestinationVariable Long id,CombatStateDTO state) throws Exception {
		//state.setDificult(combatService.calculateChallengeDeficult(state));
		state = this.combatService.updateCombatConditions(state,id);
	}
	@MessageMapping("/combat-area/{id}")
	public void recieveCombatAreaDTO(@DestinationVariable Long id,MapAreaDTO mapState) throws Exception {
		//state.setDificult(combatService.calculateChallengeDeficult(state));
		System.out.println("Chegou aquiiiieeeee");
		mapState = this.combatService.updateMapArea(mapState);
		//maps.put(Long.valueOf(id),mapState);
		//this.template.convertAndSend("/topic/combat-area/"+ id, mapState);
	     
	}
	
	
	 
}
