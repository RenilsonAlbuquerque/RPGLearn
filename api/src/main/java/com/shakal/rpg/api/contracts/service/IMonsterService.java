package com.shakal.rpg.api.contracts.service;

import com.shakal.rpg.api.dto.MonsterSheetDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;

public interface IMonsterService {
	
	MonsterSheetDTO getMonsterSheetById(long id) throws ResourceNotFoundException;

}
