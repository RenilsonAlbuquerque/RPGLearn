package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.create.RaceCreateInputDTO;
import com.shakal.rpg.api.model.Race;

public abstract class RaceMapper {
	public static RaceCreateInputDTO mapRaceEntityToMetadataDTO(Race entity) {
		RaceCreateInputDTO result = new RaceCreateInputDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setDescription(entity.getDescription());
		return result;
	}

}
