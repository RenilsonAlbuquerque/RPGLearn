package com.shakal.rpg.api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakal.rpg.api.contracts.service.ICreatureService;
import com.shakal.rpg.api.dto.info.CreatureTokenDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/creature")
public class CreatureController {
	
	@Autowired
	private ICreatureService creatureService;
	
	@GetMapping(value="/token/{id}")
    public ResponseEntity<CreatureTokenDTO> getCharacterSheet(@PathVariable Long id) throws ResourceNotFoundException{
		CreatureTokenDTO  result = this.creatureService.getCreatureToken(id);
		return new ResponseEntity<CreatureTokenDTO>(result, HttpStatus.OK);
    }

}
