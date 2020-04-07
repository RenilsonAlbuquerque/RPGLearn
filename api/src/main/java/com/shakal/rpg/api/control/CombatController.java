package com.shakal.rpg.api.control;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakal.rpg.api.contracts.service.IStoryService;
import com.shakal.rpg.api.dto.filter.CombatStateDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
import com.shakal.rpg.api.security.AuthenticationContext;


@CrossOrigin
@RestController
@RequestMapping("/combat")
public class CombatController {
	

	
	private HashMap<Long,CombatStateDTO> combats;
	private IStoryService storyService;
	
	@Autowired
    public CombatController(SimpMessagingTemplate template, IStoryService storyService) {
		 this.combats = new HashMap<Long, CombatStateDTO>();
		 this.storyService = storyService;
    }
	
	@GetMapping(value="/status/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CombatStateDTO> getInitalCombatStatus(@PathVariable Long id) throws ResourceNotFoundException{
		CombatStateDTO result = this.combats.get(id);
		if(this.combats.get(id) == null) {
			result = new CombatStateDTO();
			result.setMonsters(new ArrayList<>());
			result.setPlayers(new ArrayList<>());
			result.setDificult(1);
		}
		AuthenticationContext context = (AuthenticationContext)SecurityContextHolder.getContext().getAuthentication();
		result.setUserTypeInStory(this.storyService.checkUserRole(id, context.getId()).getValue());
		return new ResponseEntity<CombatStateDTO>(result, HttpStatus.OK);
    }
	
	
}
