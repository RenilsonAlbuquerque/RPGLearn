package com.shakal.rpg.api.mappers;

import java.util.stream.Collectors;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.info.DamageInfoDTO;
import com.shakal.rpg.api.dto.info.WeaponInfoDTO;
import com.shakal.rpg.api.dto.overview.WeaponOverviewDTO;
import com.shakal.rpg.api.model.relation.WeaponDice;
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
	public static WeaponInfoDTO entityToInfo(Weapon entity) {
		WeaponInfoDTO result = new WeaponInfoDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setDescription(entity.getDescription());
		result.setCategory(new KeyValueDTO(entity.getCategory().getId(),entity.getCategory().getName()));
		result.setClassification(new KeyValueDTO(entity.getClassification().getId(),entity.getClassification().getName()));
		result.setRange(new KeyValueDTO(entity.getRange().getId(),entity.getRange().getName()));
		result.setWeight(entity.getWeight());
		result.setImagePath(entity.getImagePath());
		result.setCost(EconomyMapper.costEntityToInfo(entity.getPrice()));
		result.setRarity(RarityMapper.entityToDTO(entity.getRarity()));
		result.setDamage(entity.getDamage()
				.stream().map(damage -> WeaponMapper.damageEntityToDTO(damage) )
				.collect(Collectors.toList())
				);
		result.setBonus(entity.getBonus());
		return result;
	}
	public static DamageInfoDTO damageEntityToDTO(WeaponDice entity) {
		DamageInfoDTO result = new DamageInfoDTO();
		result.setBonus(entity.getBonus());
		result.setQuantity(entity.getQuantity());
		result.setDamageType(DamageMapper.entityTODTO(entity.getDamageType()));
		result.setDice(DiceMapper.diceEntityToDTO(entity.getDice()));
		return result;
	}
}
