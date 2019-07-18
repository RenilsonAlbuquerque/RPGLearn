package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.model.relation.AttackDice;

public class DamageMapper {

	
	public static String  entityTOStringDTO(AttackDice entity) {
		return entity.getQuantity()+ entity.getDice().getValue().toString() + " + " +entity.getBonusDamage();
	}
}
