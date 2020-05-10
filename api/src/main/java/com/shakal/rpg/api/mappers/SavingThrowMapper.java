package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.SavingThrowDTO;
import com.shakal.rpg.api.model.relation.CreatureAtribute;

public class SavingThrowMapper {

	public static SavingThrowDTO entityToDTO(CreatureAtribute entity, int proeficiencyBonus) {
		SavingThrowDTO result = new SavingThrowDTO();
		result.setName(entity.getAtribute().getValue());
		result.setValue(entity.getModfier() + proeficiencyBonus);
		return result;
		
	}
}
