package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.info.LevelDTO;
import com.shakal.rpg.api.model.MonsterChallengeLevel;

public class LevelMapper {

	public static KeyValueDTO entityToDTO(MonsterChallengeLevel entity) {
		KeyValueDTO result = new KeyValueDTO();
		result.setId(entity.getId());
		result.setValue(entity.getValue() + " ("+ entity.getExperiencePoints()+ "XP) ");
		return result;
	}
	
	public static LevelDTO entityToInfoDTO(MonsterChallengeLevel entity) {
		LevelDTO result = new LevelDTO();
		result.setId(entity.getId());
		result.setValue(entity.getValue());
		result.setXp(entity.getExperiencePoints());
		return result;
	}
	
}
