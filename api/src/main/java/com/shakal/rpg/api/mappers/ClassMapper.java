package com.shakal.rpg.api.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.shakal.rpg.api.dto.create.ClassCreateInputDTO;
import com.shakal.rpg.api.dto.create.ClassDetailInputDTO;
import com.shakal.rpg.api.model.character.CharacterClassLevel;
import com.shakal.rpg.api.model.character.Class;
import com.shakal.rpg.api.model.character.ClassLevel;
import com.shakal.rpg.api.model.character.Character;
import com.shakal.rpg.api.model.embedded.CharacterClassLevelId;

public abstract class ClassMapper {

	public static ClassCreateInputDTO mapEntityToCreateMetadataDTO(Class entity) {
		ClassCreateInputDTO result = new ClassCreateInputDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setDescription(entity.getDescription());
		return result;
	}
	public static ClassDetailInputDTO mapEntityToCreateMetadataDetail(Class entity) {
		ClassDetailInputDTO result = new ClassDetailInputDTO();
		result.setDescription(entity.getDescription());
		result.setLifeDice(entity.getLifeDice().getValue().toString());
		result.setSavingThrows(entity.getSavingThrows().stream().map(
				atribute -> AtributeMapper.atributeToEntityDTO(atribute)
				).collect(Collectors.toList()));
		result.setProeficiencyChoose(ProeficiencyMapper.mapChooseEntityToDTO(
				entity.getStartingProficiencyOptions()));
		return result;
	}
	public static CharacterClassLevel createFistLevelOfPlayer(ClassLevel classLevel,Character character) {
		CharacterClassLevel firstLevel = new CharacterClassLevel();
		CharacterClassLevelId identifier = new CharacterClassLevelId();
		identifier.setCharacterId(character.getId());
		identifier.setClassId(classLevel.getClasS().getId());
		identifier.setLevelId(classLevel.getLevel().getId());
		firstLevel.setCharacter(character);
		firstLevel.setClassLevel(classLevel);
		firstLevel.setId(identifier);
		return firstLevel;
		
	}
}
