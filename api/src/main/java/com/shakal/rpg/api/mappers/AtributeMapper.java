package com.shakal.rpg.api.mappers;

import java.util.ArrayList;
import java.util.List;

import com.shakal.rpg.api.dto.AtributeDTO;
import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.info.AtributeInfoDTO;
import com.shakal.rpg.api.dto.info.ViewAtributeInfoDTO;
import com.shakal.rpg.api.model.Atribute;
import com.shakal.rpg.api.model.enums.AtributeEnum;
import com.shakal.rpg.api.model.relation.CreatureAtribute;
import com.shakal.rpg.api.model.character.Character;

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
	public static List<ViewAtributeInfoDTO> createSavins(Character character,int proeficiencyBonus) {
		List<ViewAtributeInfoDTO> result = new ArrayList<ViewAtributeInfoDTO>();

		boolean proeficient = character.getForce().isProeficiency();
		int value = ((proeficient) ? (character.getForce().getModfier() + proeficiencyBonus) : character.getForce().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Força"));
		
		proeficient = character.getDexterity().isProeficiency();
		value = ((proeficient) ? (character.getDexterity().getModfier() + proeficiencyBonus) : character.getDexterity().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Destreza"));
		
		proeficient = character.getConstitution().isProeficiency();
		value = ((proeficient) ? (character.getConstitution().getModfier() + proeficiencyBonus) : character.getConstitution().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Constituição"));
		
		proeficient = character.getInteligence().isProeficiency();
		value = ((proeficient) ? (character.getInteligence().getModfier() + proeficiencyBonus) : character.getInteligence().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Inteligência"));
		
		proeficient = character.getWisdom().isProeficiency();
		value = ((proeficient) ? (character.getWisdom().getModfier() + proeficiencyBonus) : character.getWisdom().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Sabedoria"));
		
		proeficient = character.getCharisma().isProeficiency();
		value = ((proeficient) ? (character.getCharisma().getModfier() + proeficiencyBonus) : character.getCharisma().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Carisma"));
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
