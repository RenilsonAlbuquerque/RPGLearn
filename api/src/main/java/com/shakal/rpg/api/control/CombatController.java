package com.shakal.rpg.api.control;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakal.rpg.api.dto.filter.ChallengeDificultInputDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/combat")
public class CombatController {
	
	@PostMapping(value="/dificuldade",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> calculateChallengeDeficult(@RequestBody ChallengeDificultInputDTO inputDto) throws ResourceNotFoundException{
		return new ResponseEntity<String>("hard", HttpStatus.OK);
    }

}
