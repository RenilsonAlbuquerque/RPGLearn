package com.shakal.rpg.api.control;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.google.common.collect.Lists;
import com.shakal.rpg.api.dto.filter.CombatStateDTO;
import com.shakal.rpg.api.dto.overview.MonsterCardDTO;

@Controller
public class CombatStompController {

	
	private final SimpMessagingTemplate template;
	
	@Autowired
	public CombatStompController(SimpMessagingTemplate simpMessagingTemplate) {
	        this.template = simpMessagingTemplate;
	}
	
	@MessageMapping("/combat/{id}")
	public void recieveDTO(@DestinationVariable String id,CombatStateDTO state) throws Exception {
		this.template.convertAndSend("/topic/combat/"+ id, state);
	     
	}
	 
}
