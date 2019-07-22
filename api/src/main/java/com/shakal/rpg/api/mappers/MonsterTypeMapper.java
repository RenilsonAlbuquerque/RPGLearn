package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.commons.KeyNameDescriptionDto;
import com.shakal.rpg.api.model.MonsterType;

public class MonsterTypeMapper {
	
	public static KeyNameDescriptionDto entityToDto(MonsterType entity) {
		KeyNameDescriptionDto result = new KeyNameDescriptionDto();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setDescription(entity.getDescription());
		return result;
	}

}
