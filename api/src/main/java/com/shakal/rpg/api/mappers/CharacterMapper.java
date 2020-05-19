package com.shakal.rpg.api.mappers;

import java.util.stream.Collectors;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.info.CharacterLifePointsDTO;
import com.shakal.rpg.api.dto.info.CharacterSheetDTO;
import com.shakal.rpg.api.dto.overview.ClassLevelOveriewDTO;
import com.shakal.rpg.api.model.character.Character;
import com.shakal.rpg.api.model.character.CharacterClassLevel;

public class CharacterMapper {
	
	public static CharacterSheetDTO entityToInfo(Character entity) {
		CharacterSheetDTO result = new CharacterSheetDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setImagePath(entity.getImagePath());
		result.setClassLevels(entity.getClassLevel().stream()
				.map(classLevel -> CharacterMapper.classLevelToInfoDTO(classLevel))
				.collect(Collectors.toList()));
		result.setRace(RaceMapper.mapRaceToOverviewDTO(entity.getRace()));
		result.setAlignment(AlignmentMapper.mapEntityTOOverviewDTO(entity.getAlignment()));
		result.setPlayer(PlayerMapper.mapEntityToOverview(entity.getUserStory().get(0).getUser()));
		
		result.setStrength(AtributeMapper.entityToDetailTO(entity.getAtributes(),1));
		result.setDexterity(AtributeMapper.entityToDetailTO(entity.getAtributes(),2));
		result.setConstitution(AtributeMapper.entityToDetailTO(entity.getAtributes(),3));
		result.setInteligence(AtributeMapper.entityToDetailTO(entity.getAtributes(),4));
		result.setWisdom(AtributeMapper.entityToDetailTO(entity.getAtributes(),5));
		result.setCharisma(AtributeMapper.entityToDetailTO(entity.getAtributes(),6));
		
		result.setInspiration(0);
		result.setProeficiencBonus(entity.getClassLevel().get(
				entity.getClassLevel().size() -1).getClassLevel().getLevel().getProeficiencyBonus()
				);
		
		result.setSavins(AtributeMapper.createSavins(entity,result.getProeficiencBonus()));
		result.setProeficiencies(ProeficiencyMapper.createProeficiencyView(entity, result.getProeficiencBonus()));
		
		result.setLanguages(entity.getLanguages().stream()
				.map( language ->  LanguageMappers.entityToDTO(language))
				.collect(Collectors.toList()));
		
		
		result.setBackground(entity.getBackgroundStory());
		result.setAge(entity.getAge());
		result.setHeight(entity.getHeight());
		result.setLifePoints(CharacterMapper.mapLevelToDTO(entity));
		
		result.setArmorClass(entity.getArmorClass());
		result.setInitiative(entity.getDexterity().getModfier());
		result.setSpeed(entity.getSpeed());
		
		return result;
	}
	public static ClassLevelOveriewDTO classLevelToInfoDTO(CharacterClassLevel classLevel) {
		ClassLevelOveriewDTO result = new ClassLevelOveriewDTO();
		KeyValueDTO clasS = new KeyValueDTO();
		clasS.setId(classLevel.getClassLevel().getClasS().getId());
		clasS.setValue(classLevel.getClassLevel().getClasS().getName());
		result.setClasS(clasS);
		
		KeyValueDTO level = new KeyValueDTO();
		level.setId(classLevel.getClassLevel().getLevel().getId());
		level.setValue(Double.toString( classLevel.getClassLevel().getLevel().getValue()));
		result.setLevel(level);
		return result;
		
	}
	public static CharacterLifePointsDTO mapLevelToDTO(Character entity) {
		CharacterLifePointsDTO result = new CharacterLifePointsDTO();
		result.setTotalLifePoints(entity.getLifePoints());
		result.setCurrentLifePoints(entity.getLifePoints());
		result.setHitDice("2d20");
		return result;
	}
	
	

}
