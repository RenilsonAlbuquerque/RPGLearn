package com.shakal.rpg.api.control;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakal.rpg.api.contracts.service.ICombatService;
import com.shakal.rpg.api.contracts.service.IStoryService;
import com.shakal.rpg.api.dto.combat.CombatDifficultDTO;
import com.shakal.rpg.api.dto.combat.CombatStateDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
import com.shakal.rpg.api.security.AuthenticationContext;


@CrossOrigin
@RestController
@RequestMapping("/combat")
public class CombatController {
	
	private IStoryService storyService;
	private ICombatService combatService;
	
	@Autowired
    public CombatController(SimpMessagingTemplate template, IStoryService storyService,
    		ICombatService combatService) {
		 this.storyService = storyService;
		 this.combatService = combatService;
    }
	
	@GetMapping(value="/status/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CombatStateDTO> getInitalCombatStatus(@PathVariable Long id) throws ResourceNotFoundException{
		return new ResponseEntity<CombatStateDTO>(this.combatService.getCombatState(id), HttpStatus.OK);
    }
	
	
}
