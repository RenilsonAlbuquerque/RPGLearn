package com.shakal.rpg.api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakal.rpg.api.contracts.service.ICharacterService;
import com.shakal.rpg.api.dto.create.CharacterCreateDTO;
import com.shakal.rpg.api.dto.create.CharacterCreateInputDTO;
import com.shakal.rpg.api.dto.filter.UserSheetFIlterDTO;
import com.shakal.rpg.api.dto.info.CharacterGeneralInfoDTO;
import com.shakal.rpg.api.dto.info.CharacterSheetDTO;
import com.shakal.rpg.api.exception.BusinessException;
import com.shakal.rpg.api.exception.ResourceNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/character")
public class CharacterController {

	@Autowired
	private ICharacterService characterService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Boolean> createCharacter(@RequestBody CharacterCreateDTO createDto) throws BusinessException{
		return new ResponseEntity<Boolean>(this.characterService.createCharacterInStory(createDto), HttpStatus.OK);
    }
	@GetMapping(value="/sheet/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CharacterSheetDTO> getCharacterSheet(@PathVariable Long id) throws ResourceNotFoundException{
		return new ResponseEntity<CharacterSheetDTO>(this.characterService.getCharacterSheet(id), HttpStatus.OK);
    }
	@PostMapping(value="/user-story",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CharacterGeneralInfoDTO> getCharacterSheetOnStory(@RequestBody UserSheetFIlterDTO filterDto) throws ResourceNotFoundException{
		return new ResponseEntity<CharacterGeneralInfoDTO>(this.characterService.getCharacterSheetByUserInStory(filterDto), HttpStatus.OK);
    }
	@GetMapping(value="/metadata",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CharacterCreateInputDTO> getCharacterCreationMetadata(){
		return new ResponseEntity<CharacterCreateInputDTO>(this.characterService.getCharacterCreationMetadata(), HttpStatus.OK);
    }
}
