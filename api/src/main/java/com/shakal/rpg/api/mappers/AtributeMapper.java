package com.shakal.rpg.api.mappers;

import java.util.List;

import com.shakal.rpg.api.dto.AtributeDTO;
import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.info.AtributeInfoDTO;
import com.shakal.rpg.api.model.Atribute;
import com.shakal.rpg.api.model.enums.AtributeEnum;
import com.shakal.rpg.api.model.relation.CreatureAtribute;

public abstract class AtributeMapper {

	public static AtributeDTO entityToSheetDTO(CreatureAtribute entity) {
		AtributeDTO result = new AtributeDTO();
		result.setName(entity.getAtribute().getValue());
		result.setValue(entity.getValue());
		result.setModfier(entity.getModfier());
		return result;
	}
	public static AtributeInfoDTO entityToDetailTO(List<CreatureAtribute> atributes,int atributeId) {
		CreatureAtribute search = null;
		for(CreatureAtribute at: atributes) {
			if(at.getAtribute().getId() == atributeId) {
				search = at;
			}
		}
		AtributeInfoDTO result = new AtributeInfoDTO();
		result.setId(search.getAtribute().getId());
		result.setValue(search.getValue());
		result.setModfier(search.getModfier());
		result.setProeficiency(search.isProeficiency());
		return result;
	}
	public static KeyValueDTO atributeToEntityDTO(Atribute atribute) {
		KeyValueDTO result = new KeyValueDTO();
		result.setId(atribute.getId());
		result.setValue(atribute.getValue());
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
