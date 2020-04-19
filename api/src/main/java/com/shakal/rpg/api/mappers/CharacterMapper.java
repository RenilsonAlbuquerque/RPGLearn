package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.info.CharacterSheetDTO;
import com.shakal.rpg.api.model.character.Character;

public class CharacterMapper {
	
	public static CharacterSheetDTO entityToInfo(Character entity) {
		CharacterSheetDTO result = new CharacterSheetDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setImagePath(entity.getImagePath());
		result.setBackground(entity.getBackgroundStory());
		result.setAge(entity.getAge());
		result.setHeight(entity.getHeight());
		result.setTotalLifePoints(entity.getLifePoints());
		result.setSpeed(entity.getSpeed());
		
		return result;
	}
	

}
