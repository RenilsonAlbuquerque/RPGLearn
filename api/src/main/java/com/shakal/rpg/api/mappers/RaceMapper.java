package com.shakal.rpg.api.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.create.CharacterRaceAtributeBonusInput;
import com.shakal.rpg.api.dto.create.CharacterRaceCreateInputDTO;
import com.shakal.rpg.api.dto.create.RaceCreateInputDTO;
import com.shakal.rpg.api.model.Race;
import com.shakal.rpg.api.model.character.CharacterRaceAtributeBonus;
import com.shakal.rpg.api.model.race.SubRace;
import com.shakal.rpg.api.model.race.SubRaceAtributeBonus;

public abstract class RaceMapper {
	public static RaceCreateInputDTO mapRaceEntityToMetadataDTO(Race entity) {
		RaceCreateInputDTO result = new RaceCreateInputDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setSubRaces(entity.getSubRaces()
				.stream().map(subRace -> RaceMapper.mapSubRaceToOverviewDTO(subRace) )
				.collect(Collectors.toList()));
		return result;
	}
	public static CharacterRaceCreateInputDTO mapSubRaceEntityToMetadataDTO(SubRace entity) {
		CharacterRaceCreateInputDTO result = new CharacterRaceCreateInputDTO();
		result.setDescription(entity.getRace().getDescription() + entity.getDescription());
		result.setSpeed(entity.getRace().getSpeed());
		result.setAgeDescription(entity.getRace().getAgeDescription());
		result.setAlignmentDescription(entity.getRace().getAlignmentDescription());
		result.setSizeDescription(entity.getRace().getSizeDescription());
		result.setLanguages(entity.getRace().getLangauges().stream().map(
				langauge -> LanguageMappers.entityToDTO(langauge))
				.collect(Collectors.toList()));
		
		List<CharacterRaceAtributeBonusInput> atributeBonus = entity.getRace().getAtributeBonus()
				.stream().map(atribute -> RaceMapper.mapRaceAtributeBonusInput(atribute) )
				.collect(Collectors.toList());
		atributeBonus.addAll(entity.getAtributeBonus()
				.stream().map( atribute -> RaceMapper.mapSubRaceAtributeBonusInput(atribute) )
				.collect(Collectors.toList())
				);
		result.setAtributeBonus(atributeBonus);
		return result;
	}
	
	public static CharacterRaceCreateInputDTO mapRaceEntityToDetail(Race race) {
		CharacterRaceCreateInputDTO result = new CharacterRaceCreateInputDTO();
		result.setDescription(race.getDescription());
		result.setSpeed(race.getSpeed());
		result.setAgeDescription(race.getAgeDescription());
		result.setAlignmentDescription(race.getAlignmentDescription());
		result.setSizeDescription(race.getSizeDescription());
		result.setLanguages(race.getLangauges().stream().map(
				langauge -> LanguageMappers.entityToDTO(langauge))
				.collect(Collectors.toList()));
		
		result.setAtributeBonus(race.getAtributeBonus()
				.stream().map(atribute -> RaceMapper.mapRaceAtributeBonusInput(atribute) )
				.collect(Collectors.toList())
				);
		return result;
	}
	public static CharacterRaceAtributeBonusInput mapRaceAtributeBonusInput(CharacterRaceAtributeBonus entity) {
		CharacterRaceAtributeBonusInput result = new CharacterRaceAtributeBonusInput();
		result.setAbility(AtributeMapper.atributeToEntityDTO(entity.getAtribute()));
		result.setBonus(entity.getBonus());
		return result;
	}
	public static CharacterRaceAtributeBonusInput mapSubRaceAtributeBonusInput(SubRaceAtributeBonus entity) {
		CharacterRaceAtributeBonusInput result = new CharacterRaceAtributeBonusInput();
		result.setAbility(AtributeMapper.atributeToEntityDTO(entity.getAtribute()));
		result.setBonus(entity.getBonus());
		return result;
	}
	public static KeyValueDTO mapSubRaceToOverviewDTO(SubRace entity) {
		KeyValueDTO result = new KeyValueDTO();
		result.setId(entity.getId());
		result.setValue(entity.getName());
		return result;
	}
	public static KeyValueDTO mapRaceToOverviewDTO(Race entity) {
		KeyValueDTO result = new KeyValueDTO();
		result.setId(entity.getId());
		result.setValue(entity.getName());
		return result;
	}
}
