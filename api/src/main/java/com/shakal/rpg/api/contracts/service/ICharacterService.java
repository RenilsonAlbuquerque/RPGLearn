package com.shakal.rpg.api.contracts.service;

import com.shakal.rpg.api.dto.create.CharacterCreateDTO;
import com.shakal.rpg.api.dto.filter.UserSheetFIlterDTO;
import com.shakal.rpg.api.dto.info.CharacterInfoDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;

public interface ICharacterService {

	boolean createCharacterInStory(CharacterCreateDTO inputDto) throws ResourceNotFoundException;
	CharacterInfoDTO getCharacterSheetByUserInStory(UserSheetFIlterDTO filter) throws ResourceNotFoundException;
}
