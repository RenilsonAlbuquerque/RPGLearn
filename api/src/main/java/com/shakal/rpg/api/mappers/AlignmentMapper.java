package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.model.Alignment;

public class AlignmentMapper {

	public static KeyValueDTO mapEntityTOOverviewDTO(Alignment entity) {
		KeyValueDTO result = new KeyValueDTO();
		result.setId(entity.getId());
		result.setValue(entity.getName());
		return result;
	}
}
