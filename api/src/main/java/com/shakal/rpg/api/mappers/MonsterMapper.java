package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.info.MonsterInfoDTO;
import com.shakal.rpg.api.dto.overview.MonsterOverviewDTO;
import com.shakal.rpg.api.model.Monster;
import com.shakal.rpg.api.model.creature.CreatureSize;

public class MonsterMapper {

	public static MonsterOverviewDTO entityToOverview(Monster entity) {
		MonsterOverviewDTO result = new MonsterOverviewDTO();
		result.setId(entity.getId());
		result.setRace(entity.getRace().getName());
		result.setType(entity.getRace().getMonsterType().getName());
		result.setChallengeLevel(entity.getChallengeLevel().getValue());
		result.setLifePoints(entity.getBaseLifeDice());
		return result;
	}
	public static MonsterInfoDTO entityToInfo(Monster entity) {
		MonsterInfoDTO result = new MonsterInfoDTO();
		result.setRace(entity.getRace().getName());
		result.setProfilePicturePath(entity.getImagePath());
		result.setType(entity.getRace().getMonsterType().getName());
		result.setDescription(entity.getRace().getDescription());
		return result;
	}
	public static KeyValueDTO sizeEntityToDTO(CreatureSize entity) {
		KeyValueDTO result = new KeyValueDTO();
		result.setId(entity.getId());
		result.setValue(entity.getName());
		return result;
		
	}
}
