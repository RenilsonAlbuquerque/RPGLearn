package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.commons.NameDescriptionDTO;
import com.shakal.rpg.api.model.MonsterFeatures;

public class FeatureMapper {

	public static NameDescriptionDTO entityToDTO(MonsterFeatures entity) {
		NameDescriptionDTO result = new NameDescriptionDTO();
		result.setName(entity.getName());
		result.setDescription(entity.getDescription());
		return result;
	}
}
