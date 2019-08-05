package com.shakal.rpg.api.mappers;

import java.util.stream.Collectors;

import com.shakal.rpg.api.dto.MonsterActionDTO;
import com.shakal.rpg.api.dto.create.ActionCreateDTO;
import com.shakal.rpg.api.model.Action;
import com.shakal.rpg.api.model.Attack;

public class ActionMapper {

	/*
	public static Action dtoToGenericEntity(ActionCreateDTO dto) {
		Action result = null;
		if(dto.getDamages().isEmpty()) {
			result = new Action();
			result.setName(dto.getName());
			result.setDescription(dto.getDescription());
			
		}else {
			result = new Attack();
			result.setName(dto.getName());
			result.setDescription(dto.getDescription());
			((Attack) result).setDamage(dto.getDamages().stream()
					.map(damage -> DamageMapper.damageDiceDtoToEntity(damage)).collect(Collectors.toList()));
			
		}
		
		return result;
	}
	*/
}
