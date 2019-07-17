package com.shakal.rpg.api.service;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.IMonsterService;
import com.shakal.rpg.api.dto.MonsterSheetDTO;
import com.shakal.rpg.api.model.Monster;
import com.shakal.rpg.api.model.enums.ResistenceTypeEnum;
import com.shakal.rpg.api.repository.MonsterDAO;
import com.shakal.rpg.api.exception.*;
import com.shakal.rpg.api.mappers.AtributeMapper;
import com.shakal.rpg.api.mappers.FeatureMapper;
import com.shakal.rpg.api.mappers.SavingThrowMapper;
import com.shakal.rpg.api.utils.Messages;



@Service
public class MonsterService implements IMonsterService {

	private MonsterDAO monsterDao;
	
	@Autowired
	public MonsterService(MonsterDAO monsterDao) {
		this.monsterDao = monsterDao;
	}

	@Override
	public MonsterSheetDTO getMonsterSheetById(long id) throws ResourceNotFoundException {
		Monster search = this.monsterDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(Messages.MONSTER_NOT_FOUND));
		
		MonsterSheetDTO result = new MonsterSheetDTO();
		result.setId(search.getId());
		result.setName(search.getRace().getName());
		result.setArmorClass(search.getArmorClass());
		result.setLifePoints(search.getBaseLifeDice());
		result.setAtributes( search.getAtributes().stream().map(
				atribute -> AtributeMapper.entityToSheetDTO(atribute)).collect(Collectors.toList()));
		result.setDamageResistence( search.getResistences().stream()
				.filter(resistence -> resistence.getType().getValue() == ResistenceTypeEnum.RESISTENCE.getValue())
				.map(resistence -> resistence.getDamageType().getValue().toString()).collect(Collectors.toList()));
		result.setDamageImunity( search.getResistences().stream()
				.filter(resistence -> resistence.getType().getValue() == ResistenceTypeEnum.IMUNITY.getValue())
				.map(resistence -> resistence.getDamageType().getValue().toString()).collect(Collectors.toList()));
		result.setLanguages( search.getLanguages().stream()
				.map(language -> language.getName()).collect(Collectors.toList()));
		result.setFeatures( search.getFeatures().stream().map(
				feature -> FeatureMapper.entityToDTO(feature)).collect(Collectors.toList()));
		result.setSavingThrows( search.getAtributes().stream().filter(saving -> saving.isProeficiency()).map(
				saving -> SavingThrowMapper.entityToDTO(saving)).collect(Collectors.toList()));
		
		return result;
	}
	
	
}
