package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.AtributeDTO;
import com.shakal.rpg.api.model.enums.AtributeEnum;
import com.shakal.rpg.api.model.relation.CreatureAtribute;

public class AtributeMapper {

	public static AtributeDTO entityToSheetDTO(CreatureAtribute entity) {
		AtributeDTO result = new AtributeDTO();
		result.setName(translate(entity.getAtribute().getValue()));
		result.setValue(entity.getValue());
		result.setModfier(entity.getModfier());
		return result;
	}
	
	public static String translate(AtributeEnum enumInput) {
		String result = "";
		switch(enumInput) {
			case FORCE: 
				result = "For";
				break;
			case DEXTERITY: 
				result = "Des";
				break;
			case CONSTITUTION: 
				result = "Con";
				break;
			case INTELIGENCE: 
				result = "Int";
				break;
			case WISDOM: 
				result = "Sab";
				break;
			case CHARISMA: 
				result = "Car";
				break;
			default:
				break;
		}
		return result;
		
	}
}
