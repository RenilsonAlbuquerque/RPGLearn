package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.overview.WeaponOverviewDTO;
import com.shakal.rpg.api.model.weapon.Weapon;

public abstract class WeaponMapper {

	public static WeaponOverviewDTO entityToOverview(Weapon entity) {
		WeaponOverviewDTO result = new WeaponOverviewDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setCategory(new KeyValueDTO(entity.getCategory().getId(),entity.getCategory().getName()));
		result.setClassification(new KeyValueDTO(entity.getClassification().getId(),entity.getClassification().getName()));
		result.setRange(new KeyValueDTO(entity.getRange().getId(),entity.getRange().getName()));
		return result;
	}
}
