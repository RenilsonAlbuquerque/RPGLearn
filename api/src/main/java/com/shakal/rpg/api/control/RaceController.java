package com.shakal.rpg.api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakal.rpg.api.contracts.service.IRaceService;
import com.shakal.rpg.api.dto.create.CharacterRaceCreateInputDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/race")
public class RaceController {
	
	@Autowired
	private IRaceService raceService;
	
	@GetMapping("/info/{id}")
	public ResponseEntity<CharacterRaceCreateInputDTO> getRaceInfoById(@PathVariable Long id) throws ResourceNotFoundException {    	
	    return new ResponseEntity<CharacterRaceCreateInputDTO>(this.raceService.getCharacterRaceMetadata(id), HttpStatus.OK);
	}
	@GetMapping("/subrace/info/{id}")
	public ResponseEntity<CharacterRaceCreateInputDTO> getSubRaceInfoById(@PathVariable Long id) throws ResourceNotFoundException {
	    return new ResponseEntity<CharacterRaceCreateInputDTO>(this.raceService.getCharacterSubRaceMetadata(id), HttpStatus.OK);
	}

}
