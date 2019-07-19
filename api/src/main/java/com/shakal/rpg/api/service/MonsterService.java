package com.shakal.rpg.api.service;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.IMonsterService;
import com.shakal.rpg.api.dto.MonsterSheetDTO;
import com.shakal.rpg.api.dto.filter.CustomPage;
import com.shakal.rpg.api.dto.filter.PaginationFilter;
import com.shakal.rpg.api.dto.overview.MonsterOverviewDTO;
import com.shakal.rpg.api.model.Attack;
import com.shakal.rpg.api.model.Monster;
import com.shakal.rpg.api.model.enums.ResistenceTypeEnum;
import com.shakal.rpg.api.repository.MonsterDAO;
import com.shakal.rpg.api.specification.MonsterSpecification;
import com.shakal.rpg.api.exception.*;
import com.shakal.rpg.api.mappers.AtributeMapper;
import com.shakal.rpg.api.mappers.AttackMapper;
import com.shakal.rpg.api.mappers.FeatureMapper;
import com.shakal.rpg.api.mappers.MonsterMapper;
import com.shakal.rpg.api.mappers.SavingThrowMapper;
import com.shakal.rpg.api.utils.Messages;
import com.shakal.rpg.api.utils.PaginationGenerator;





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
		result.setChallengeLevel(search.getChallengeLevel().getValue() + " " 
								+ "(" + search.getChallengeLevel().getExperiencePoints() + " XP)");
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
		
		result.setActions(search.getActions().stream().filter(attack -> attack instanceof Attack)
				.map(attack -> AttackMapper.entityToDTO((Attack)attack))
				.collect(Collectors.toList()));
		
		return result;
	}

	@Override
	public CustomPage<MonsterOverviewDTO> searchMonsterPaged(HashMap<String, Object> params, PaginationFilter filter) {
		Specification<Monster> specification = MonsterSpecification.searchMonster(params);
	    
    	Page<Monster> page = this.monsterDao.findAll(specification,PageRequest.of(filter.getPage() -1, 
				filter.getSize()));
    	return (CustomPage<MonsterOverviewDTO>) PaginationGenerator.convertPage(page,page
        		.stream().map( monster -> MonsterMapper.entityToOverview(monster))
                .collect(Collectors.toList()));
	}

	@Override
	public CustomPage<MonsterOverviewDTO> listsMonsterPaged(PaginationFilter filter) {
		Page<Monster> page = this.monsterDao.findAll(PageRequest.of(filter.getPage() -1, 
				filter.getSize()));
    	return (CustomPage<MonsterOverviewDTO>) PaginationGenerator.convertPage(page,page
        		.stream().map( monster -> MonsterMapper.entityToOverview(monster))
                .collect(Collectors.toList()));
	}
	
	
}
