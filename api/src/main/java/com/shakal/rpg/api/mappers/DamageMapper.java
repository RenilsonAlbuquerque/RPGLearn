package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.model.DamageType;
import com.shakal.rpg.api.model.relation.AttackDice;

public class DamageMapper {

	
	public static String  entityTOStringDTO(AttackDice entity) {
		return entity.getQuantity()+ entity.getDice().getValue().toString() + " + " +entity.getBonusDamage();
	}
	
	public static KeyValueDTO  entityTODTO(DamageType entity) {
		KeyValueDTO result = new KeyValueDTO();
		result.setId(entity.getId());
		result.setValue(entity.getValue().toString());
		return result;
	}
}
