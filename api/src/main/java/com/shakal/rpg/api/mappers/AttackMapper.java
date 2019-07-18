package com.shakal.rpg.api.mappers;

import java.util.stream.Collectors;

import com.shakal.rpg.api.dto.MonsterActionDTO;
import com.shakal.rpg.api.model.Attack;

public class AttackMapper {

	public static MonsterActionDTO entityToDTO(Attack entity) {
		MonsterActionDTO action = new MonsterActionDTO();
		action.setName(entity.getName());
		action.setDescription(entity.getDescription());
		action.setDamage(entity.getDamage().stream()
				.map(damage -> DamageMapper.entityTOStringDTO(damage)).collect(Collectors.toList()));
		return action;
	}
	
}
