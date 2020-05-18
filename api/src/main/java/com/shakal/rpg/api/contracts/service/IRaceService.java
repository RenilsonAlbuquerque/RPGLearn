package com.shakal.rpg.api.contracts.service;

import com.shakal.rpg.api.dto.create.CharacterRaceCreateInputDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;

public interface IRaceService {
	
	CharacterRaceCreateInputDTO getCharacterRaceMetadata(Long raceId) throws ResourceNotFoundException;
	CharacterRaceCreateInputDTO getCharacterSubRaceMetadata(Long raceId) throws ResourceNotFoundException;

}
