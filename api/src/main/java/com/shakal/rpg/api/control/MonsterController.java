package com.shakal.rpg.api.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakal.rpg.api.contracts.service.IMonsterService;
import com.shakal.rpg.api.dto.MonsterSheetDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;



@CrossOrigin
@RestController
@RequestMapping("/monster")
public class MonsterController {

	@Autowired
	private IMonsterService monsterService;
	
	
	@GetMapping("/sheet/{id}")
    public ResponseEntity<MonsterSheetDTO> getMonsterById(@PathVariable Long id) throws ResourceNotFoundException {
    	
        return new ResponseEntity<MonsterSheetDTO>(monsterService.getMonsterSheetById(id), HttpStatus.OK);
    }
	

}
