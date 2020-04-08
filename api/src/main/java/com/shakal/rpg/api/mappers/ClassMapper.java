package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.create.ClassCreateInputDTO;
import com.shakal.rpg.api.model.character.Class;

public abstract class ClassMapper {

	public static ClassCreateInputDTO mapEntityToCreateMetadataDTO(Class entity) {
		ClassCreateInputDTO result = new ClassCreateInputDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setDescription(entity.getDescription());
		return result;
	}
}
