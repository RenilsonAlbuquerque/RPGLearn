package com.shakal.rpg.api.mappers;

import java.util.stream.Collectors;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.create.ProeficiencyChoseInputDTO;
import com.shakal.rpg.api.model.character.ClassStartingProeficiencyChoice;
import com.shakal.rpg.api.model.creature.Proeficiency;

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
}
