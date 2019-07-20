package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.info.MonsterInfoDTO;
import com.shakal.rpg.api.dto.overview.MonsterOverviewDTO;
import com.shakal.rpg.api.model.Monster;

public class MonsterMapper {

	public static MonsterOverviewDTO entityToOverview(Monster entity) {
		MonsterOverviewDTO result = new MonsterOverviewDTO();
		result.setId(entity.getId());
		result.setRace(entity.getRace().getName());
		result.setType(entity.getRace().getMonsterType().getName());
		result.setChallengeLevel(entity.getChallengeLevel().getValue());
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
}
