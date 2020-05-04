package com.shakal.rpg.api.mappers;

import java.util.HashSet;
import java.util.List;

import com.shakal.rpg.api.dto.commons.NameDescriptionDTO;
import com.shakal.rpg.api.model.Monster;
import com.shakal.rpg.api.model.MonsterFeature;

public class FeatureMapper {

	public static NameDescriptionDTO entityToDTO(MonsterFeature entity) {
		NameDescriptionDTO result = new NameDescriptionDTO();
		result.setName(entity.getName());
		result.setDescription(entity.getDescription());
		return result;
	}
	public static MonsterFeature dtoToEntity(NameDescriptionDTO inputDto) {
		MonsterFeature entity = new MonsterFeature();
		entity.setName(inputDto.getName());
		entity.setDesctiption(inputDto.getDescription());
		return entity;
	}
	public static MonsterFeature dtoToEntityWithRelation(NameDescriptionDTO inputDto, Monster monster) {
		MonsterFeature entity = new MonsterFeature();
		entity.setName(inputDto.getName());
		entity.setDesctiption(inputDto.getDescription());
		entity.setMonster(monster);
		return entity;
	}
	public static Monster saveFeatures(List<NameDescriptionDTO> inputDto, Monster monster) {

		monster.setFeatures(new HashSet<>());
		for(NameDescriptionDTO ft: inputDto) {
			MonsterFeature entity = FeatureMapper.dtoToEntity(ft);
			monster.getFeatures().add(entity);
			entity.setMonster(monster);
		}
		return monster;
		
	}
}
