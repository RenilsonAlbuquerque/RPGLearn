package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.SavingThrowDTO;
import com.shakal.rpg.api.model.relation.CreatureAtribute;

public class SavingThrowMapper {

	public static SavingThrowDTO entityToDTO(CreatureAtribute entity) {
		SavingThrowDTO result = new SavingThrowDTO();
		result.setName(AtributeMapper.translate(entity.getAtribute().getValue()));
		result.setValue(entity.getValue());
		return result;
		
	}
}
