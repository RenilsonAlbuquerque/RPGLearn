package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.AtributeDTO;
import com.shakal.rpg.api.model.relation.CreatureAtribute;

public class AtributeMapper {

	public static AtributeDTO entityToSheetDTO(CreatureAtribute entity) {
		AtributeDTO result = new AtributeDTO();
		result.setName(entity.getAtribute().getValue().toString());
		result.setValue(entity.getValue());
		result.setModfier(entity.getModfier());
		return result;
	}
}
