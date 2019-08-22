package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.info.CharacterInfoDTO;
import com.shakal.rpg.api.model.character.Character;

public class CharacterMapper {
	
	public static CharacterInfoDTO entityToInfo(Character entity) {
		CharacterInfoDTO result = new CharacterInfoDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setImagePath(entity.getImagePath());
		result.setBackground(entity.getBackgroundStory());
		result.setAge(entity.getAge());
		result.setHeight(entity.getHeight());
		
		return result;
	}

}
