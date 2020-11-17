package com.shakal.rpg.api.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakal.rpg.api.contracts.service.ICharacterService;
import com.shakal.rpg.api.contracts.service.ICombatService;
import com.shakal.rpg.api.contracts.service.IStoryService;
import com.shakal.rpg.api.dto.combat.CombatStateDTO;
import com.shakal.rpg.api.dto.combat.PassTurnDTO;
import com.shakal.rpg.api.dto.filter.UserSheetFIlterDTO;
import com.shakal.rpg.api.dto.info.CharacterGeneralInfoDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;


@CrossOrigin
@RestController
@RequestMapping("/combat")
public class CombatController {
	
	private IStoryService storyService;
	private ICombatService combatService;
	private ICharacterService characterService;
	
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
	
	
	@PostMapping(value="/pass-turn")
	public ResponseEntity<Boolean> passTurn(@RequestBody PassTurnDTO passTurnDto) throws ResourceNotFoundException{
		return new ResponseEntity<Boolean>(this.combatService.passTurn(passTurnDto), HttpStatus.OK);
    }
	
	@GetMapping(value="/start-combat/{id}")
	public ResponseEntity<Boolean> startCombat(@PathVariable Long id) throws ResourceNotFoundException{
		return new ResponseEntity<Boolean>(this.combatService.startCombat(id), HttpStatus.OK);
    }
	@PostMapping(value="/enter-combat",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CharacterGeneralInfoDTO> enterInCombat(@RequestBody UserSheetFIlterDTO filterDto) throws ResourceNotFoundException{
		return new ResponseEntity<CharacterGeneralInfoDTO>(this.combatService.enterInCombat(filterDto), HttpStatus.OK);
    }
	@PostMapping(value="/reset-combat",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Boolean> resetCombat(@PathVariable Long id) throws ResourceNotFoundException{
		return new ResponseEntity<Boolean>(this.combatService.resetCombat(id), HttpStatus.OK);
    }
	
	/*
	@GetMapping(value="/reset-combat/{id}")
	public ResponseEntity<Boolean> resetCombat(@PathVariable Long id) throws ResourceNotFoundException{
		return new ResponseEntity<Boolean>(this.combatService.startCombat(id), HttpStatus.OK);
    }
	*/
}
