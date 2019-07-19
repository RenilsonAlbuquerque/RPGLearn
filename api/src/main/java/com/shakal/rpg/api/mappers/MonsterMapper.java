package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.overview.MonsterOverviewDTO;
import com.shakal.rpg.api.model.Monster;

public class MonsterMapper {

	public static MonsterOverviewDTO entityToOverview(Monster entity) {
		MonsterOverviewDTO result = new MonsterOverviewDTO();
		result.setId(entity.getId());
		result.setRace(entity.getRace().getName());
		result.setType(entity.getRace().getName());
		result.setChallengeLevel(entity.getChallengeLevel().getValue() + " (" + entity.getChallengeLevel().getExperiencePoints() + ")");
		return result;
	}
}
