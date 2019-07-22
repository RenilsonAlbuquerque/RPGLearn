package com.shakal.rpg.api.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.IMonsterService;
import com.shakal.rpg.api.dto.MonsterSheetDTO;
import com.shakal.rpg.api.dto.create.MonsterCreateDTO;
import com.shakal.rpg.api.dto.create.MonsterCreateInputDTO;
import com.shakal.rpg.api.dto.filter.CustomPage;
import com.shakal.rpg.api.dto.filter.PaginationFilter;
import com.shakal.rpg.api.dto.info.MonsterInfoDTO;
import com.shakal.rpg.api.dto.overview.MonsterOverviewDTO;
import com.shakal.rpg.api.model.Attack;
import com.shakal.rpg.api.model.Monster;
import com.shakal.rpg.api.model.enums.ResistenceTypeEnum;
import com.shakal.rpg.api.repository.AlignmentDAO;
import com.shakal.rpg.api.repository.DamageTypeDAO;
import com.shakal.rpg.api.repository.LanguageDAO;
import com.shakal.rpg.api.repository.MonsterChallengeLevelDAO;
import com.shakal.rpg.api.repository.MonsterDAO;
import com.shakal.rpg.api.repository.MonsterSizeDAO;
import com.shakal.rpg.api.repository.MonsterTypeDAO;
import com.shakal.rpg.api.specification.MonsterSpecification;
import com.shakal.rpg.api.exception.*;
import com.shakal.rpg.api.mappers.AtributeMapper;
import com.shakal.rpg.api.mappers.AttackMapper;
import com.shakal.rpg.api.mappers.CreatureMapper;
import com.shakal.rpg.api.mappers.DamageMapper;
import com.shakal.rpg.api.mappers.FeatureMapper;
import com.shakal.rpg.api.mappers.LanguageMappers;
import com.shakal.rpg.api.mappers.LevelMapper;
import com.shakal.rpg.api.mappers.MonsterMapper;
import com.shakal.rpg.api.mappers.MonsterTypeMapper;
import com.shakal.rpg.api.mappers.SavingThrowMapper;
import com.shakal.rpg.api.utils.Messages;
import com.shakal.rpg.api.utils.PaginationGenerator;





@Service
public class MonsterService implements IMonsterService {

	private MonsterDAO monsterDao;
	private LanguageDAO languageDao;
	private MonsterChallengeLevelDAO challengeLevelDao;
	private DamageTypeDAO damageTypeDao;
	private MonsterTypeDAO monsterTypeDao;
	private MonsterSizeDAO monsterSizeDao;
	private AlignmentDAO alignmentDao;
	
	@Autowired
	public MonsterService(MonsterDAO monsterDao,LanguageDAO languageDao, 
			MonsterChallengeLevelDAO monsterChallengeDao, DamageTypeDAO damageTypeDao,
			MonsterTypeDAO monsterTypeDao, MonsterSizeDAO monsterSizeDao,
			AlignmentDAO alignmentDao) {
		this.monsterDao = monsterDao;
		this.languageDao = languageDao;
		this.challengeLevelDao = monsterChallengeDao;
		this.damageTypeDao = damageTypeDao;
		this.monsterTypeDao = monsterTypeDao;
		this.monsterSizeDao = monsterSizeDao;
		this.alignmentDao = alignmentDao;
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
	public CustomPage<MonsterOverviewDTO> searchMonsterPaged(String name, PaginationFilter filter) {
		Specification<Monster> specification = MonsterSpecification.searchMonster(name);
	    
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

	@Override
	public MonsterInfoDTO getMonsterInfoById(long id) throws ResourceNotFoundException {
		Monster search = this.monsterDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(Messages.MONSTER_NOT_FOUND));
		return MonsterMapper.entityToInfo(search);
		
	}

	@Override
	public MonsterCreateInputDTO getMonsterInfoToCreate() {
		MonsterCreateInputDTO result = new MonsterCreateInputDTO();
		result.setAlignments(this.alignmentDao.findAll().stream()
				.map(alignment -> CreatureMapper.alignmentEntityToDTO(alignment))
				.collect(Collectors.toList()));
		result.setSizes(this.monsterSizeDao.findAll().stream()
				.map(size-> MonsterMapper.sizeEntityToDTO(size))
				.collect(Collectors.toList()));
		result.setTypes(this.monsterTypeDao.findAll().stream()
				.map(type -> MonsterTypeMapper.entityToDto(type))
				.collect(Collectors.toList()));
		result.setLanguages(this.languageDao.findAll().stream()
				.map(language -> LanguageMappers.entityToDTO(language) )
				.collect(Collectors.toList()));
		result.setLevels(this.challengeLevelDao.findAll().stream()
				.map(level -> LevelMapper.entityToDTO(level) )
				.collect(Collectors.toList()));
		result.setDamageType(this.damageTypeDao.findAll().stream()
				.map(damage -> DamageMapper.entityTODTO(damage))
				.collect(Collectors.toList()));
		return result;
	}

	@Override
	public MonsterCreateDTO insertMonster(MonsterCreateDTO inputDto) throws ResourceNotFoundException {
		Monster entity = new Monster();
		//entity.setRace(new MonsterRace());
		return inputDto;
	}
	
	
}
