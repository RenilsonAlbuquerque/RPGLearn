package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.create.DamageDiceDTO;
import com.shakal.rpg.api.model.DamageType;
import com.shakal.rpg.api.model.Dice;
import com.shakal.rpg.api.model.enums.DamageTypeEnum;
import com.shakal.rpg.api.model.relation.AttackDice;

public class DamageMapper {

	
	public static String entityTOStringDTO(AttackDice entity) {
		return entity.getQuantity()+ entity.getDice().getValue().toString() + " + " +entity.getBonusDamage();
	}
	
	
	public static AttackDice damageDiceDtoToEntity(DamageDiceDTO inputDto, Dice dice, DamageType damageType) {
		
		AttackDice result = new AttackDice();
		result.setDice(dice);
		result.setQuantity(inputDto.getQuantity());
		result.setDamageType(damageType);
		return result;
		
	}
	
	public static KeyValueDTO  entityTODTO(DamageType entity) {
		KeyValueDTO result = new KeyValueDTO();
		result.setId(entity.getId());
		result.setValue(entity.getValue());
		return result;
	}
	
	public static String translateDamage(DamageTypeEnum enumInput) {
		String result = "";
		switch(enumInput) {
			case ACID: 
				result = "�cido";
				break;
			case BLUDGEONING: 
				result = "Concuss�o";
				break;
			case COLD: 
				result = "Gelo";
				break;
			case FIRE: 
				result = "Fogo";
				break;
			case FORCE: 
				result = "For�a";
				break;
			case LIGHTNING: 
				result = "El�trico";
				break;
			case NECROTIC:
				result = "Necr�tico";
				break;
			case PIERCING: 
				result = "Perfurante";
				break;
			case POISON: 
				result = "Veneno";
				break;
			case PSYCHIC:
				result = "Ps�quico";
				break;
			case RADIANT: 
				result = "Radiante";
				break;
			case SLASHING: 
				result = "Veneno";
				break;
			case THUNDER:
				result = "Trov�o";
				break;
			default:
				break;
		}
		return result;
		
	}
}
