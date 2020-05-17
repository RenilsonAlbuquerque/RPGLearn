package com.shakal.rpg.api.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.create.ProeficiencyChoseInputDTO;
import com.shakal.rpg.api.dto.info.ViewAtributeInfoDTO;
import com.shakal.rpg.api.model.character.ClassStartingProeficiencyChoice;
import com.shakal.rpg.api.model.creature.Proeficiency;
import com.shakal.rpg.api.model.character.Character;

public abstract class ProeficiencyMapper {

	public static ProeficiencyChoseInputDTO mapChooseEntityToDTO(ClassStartingProeficiencyChoice entity) {
		ProeficiencyChoseInputDTO result = new ProeficiencyChoseInputDTO();
		result.setChoose(entity.getChoose());
		result.setProeficiencies(entity.getProeficiencyChoices().stream()
				.map(proeficiency -> mapEntityToDTO(proeficiency) )
				.collect(Collectors.toList()));
		return result;
	}
	public static KeyValueDTO mapEntityToDTO(Proeficiency entity) {
		KeyValueDTO result = new KeyValueDTO();
		result.setId(entity.getId());
		result.setValue(entity.getName());
		return result;
	}
	public static List<ViewAtributeInfoDTO> createProeficiencyView(Character character, int proeficiencyBonus){
		List<ViewAtributeInfoDTO> result = new ArrayList<ViewAtributeInfoDTO>();
		boolean proeficient = character.getProeficiencies().stream().anyMatch(proe -> (proe.getId() == 1));
		int value = ((proeficient) ? (character.getDexterity().getModfier() + proeficiencyBonus) : character.getDexterity().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Acrobacia"));
		
		proeficient = character.getProeficiencies().stream().anyMatch(proe -> (proe.getId() == 2));
		value = ((proeficient) ? (character.getInteligence().getModfier() + proeficiencyBonus) : character.getInteligence().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Arcanimso"));
		
		proeficient = character.getProeficiencies().stream().anyMatch(proe -> (proe.getId() == 3));
		value = ((proeficient) ? (character.getForce().getModfier() + proeficiencyBonus) : character.getForce().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Atletismo"));
		
		proeficient = character.getProeficiencies().stream().anyMatch(proe -> (proe.getId() == 4));
		value = ((proeficient) ? (character.getCharisma().getModfier() + proeficiencyBonus) : character.getCharisma().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Atuação"));
		
		proeficient = character.getProeficiencies().stream().anyMatch(proe -> (proe.getId() == 5));
		value = ((proeficient) ? (character.getCharisma().getModfier() + proeficiencyBonus) : character.getCharisma().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Blefar"));
		
		proeficient = character.getProeficiencies().stream().anyMatch(proe -> (proe.getId() == 6));
		value = ((proeficient) ? (character.getDexterity().getModfier() + proeficiencyBonus) : character.getDexterity().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Furtividade"));
		
		proeficient = character.getProeficiencies().stream().anyMatch(proe -> (proe.getId() == 7));
		value = ((proeficient) ? (character.getInteligence().getModfier() + proeficiencyBonus) : character.getInteligence().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "História"));
		
		proeficient = character.getProeficiencies().stream().anyMatch(proe -> (proe.getId() == 8));
		value = ((proeficient) ? (character.getCharisma().getModfier() + proeficiencyBonus) : character.getCharisma().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Intimidação"));
		
		proeficient = character.getProeficiencies().stream().anyMatch(proe -> (proe.getId() == 9));
		value = ((proeficient) ? (character.getWisdom().getModfier() + proeficiencyBonus) : character.getWisdom().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Intuição"));
		
		proeficient = character.getProeficiencies().stream().anyMatch(proe -> (proe.getId() == 10));
		value = ((proeficient) ? (character.getInteligence().getModfier() + proeficiencyBonus) : character.getInteligence().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Investigação"));
		
		proeficient = character.getProeficiencies().stream().anyMatch(proe -> (proe.getId() == 11));
		value = ((proeficient) ? (character.getWisdom().getModfier() + proeficiencyBonus) : character.getWisdom().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Lidar com animais"));
		
		proeficient = character.getProeficiencies().stream().anyMatch(proe -> (proe.getId() == 12));
		value = ((proeficient) ? (character.getWisdom().getModfier() + proeficiencyBonus) : character.getWisdom().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Medicina"));
		
		proeficient = character.getProeficiencies().stream().anyMatch(proe -> (proe.getId() == 13));
		value = ((proeficient) ? (character.getInteligence().getModfier() + proeficiencyBonus) : character.getInteligence().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Natureza"));
		
		proeficient = character.getProeficiencies().stream().anyMatch(proe -> (proe.getId() == 14));
		value = ((proeficient) ? (character.getWisdom().getModfier() + proeficiencyBonus) : character.getWisdom().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Percepção"));
		
		proeficient = character.getProeficiencies().stream().anyMatch(proe -> (proe.getId() == 15));
		value = ((proeficient) ? (character.getCharisma().getModfier() + proeficiencyBonus) : character.getCharisma().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Persuasão"));
		
		proeficient = character.getProeficiencies().stream().anyMatch(proe -> (proe.getId() == 16));
		value = ((proeficient) ? (character.getDexterity().getModfier() + proeficiencyBonus) : character.getDexterity().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Prestidigitação"));
		
		proeficient = character.getProeficiencies().stream().anyMatch(proe -> (proe.getId() == 17));
		value = ((proeficient) ? (character.getInteligence().getModfier() + proeficiencyBonus) : character.getInteligence().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Religião"));
		
		proeficient = character.getProeficiencies().stream().anyMatch(proe -> (proe.getId() == 18));
		value = ((proeficient) ? (character.getWisdom().getModfier() + proeficiencyBonus) : character.getWisdom().getModfier());
		result.add(new ViewAtributeInfoDTO( proeficient, value, "Sobrevivência"));
		return result;
	}
	private boolean isProeficienct(int id,List<Proeficiency> proeficiencies ) {
		return proeficiencies.stream()
			.anyMatch(proe -> (proe.getId() == id));
	}
}
