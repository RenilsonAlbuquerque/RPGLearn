package com.shakal.rpg.api.service;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.IMonsterService;
import com.shakal.rpg.api.dto.MonsterSheetDTO;
import com.shakal.rpg.api.dto.combat.CreatureCardDTO;
import com.shakal.rpg.api.dto.create.MonsterCreateDTO;
import com.shakal.rpg.api.dto.create.MonsterCreateInputDTO;
import com.shakal.rpg.api.dto.filter.CustomPage;
import com.shakal.rpg.api.dto.filter.PaginationFilter;
import com.shakal.rpg.api.dto.info.MonsterInfoDTO;
import com.shakal.rpg.api.dto.overview.MonsterOverviewDTO;
import com.shakal.rpg.api.model.Alignment;
import com.shakal.rpg.api.model.Attack;
import com.shakal.rpg.api.model.Monster;
import com.shakal.rpg.api.model.CreatureLevel;
import com.shakal.rpg.api.model.MonsterRace;
import com.shakal.rpg.api.model.MonsterType;
import com.shakal.rpg.api.model.creature.CreatureSize;
import com.shakal.rpg.api.model.embedded.CreatureAtributeId;
import com.shakal.rpg.api.model.enums.ResistenceTypeEnum;
import com.shakal.rpg.api.model.relation.CreatureAtribute;
import com.shakal.rpg.api.repository.AlignmentDAO;
import com.shakal.rpg.api.repository.AtributeDAO;
import com.shakal.rpg.api.repository.CreatureAtributeDAO;
import com.shakal.rpg.api.repository.DamageTypeDAO;
import com.shakal.rpg.api.repository.DiceDAO;
import com.shakal.rpg.api.repository.ImageTokenDAO;
import com.shakal.rpg.api.repository.LanguageDAO;
import com.shakal.rpg.api.repository.MonsterChallengeLevelDAO;
import com.shakal.rpg.api.repository.MonsterDAO;
import com.shakal.rpg.api.repository.MonsterFeatureDAO;
import com.shakal.rpg.api.repository.MonsterSizeDAO;
import com.shakal.rpg.api.repository.MonsterTypeDAO;
import com.shakal.rpg.api.specification.MonsterSpecification;
import com.shakal.rpg.api.exception.*;
import com.shakal.rpg.api.helpers.AtributeHelper;
import com.shakal.rpg.api.helpers.SizeHelper;
import com.shakal.rpg.api.mappers.AtributeMapper;
import com.shakal.rpg.api.mappers.AttackMapper;
import com.shakal.rpg.api.mappers.CreatureMapper;
import com.shakal.rpg.api.mappers.CreatureTokenMapper;
import com.shakal.rpg.api.mappers.DamageMapper;
import com.shakal.rpg.api.mappers.DiceMapper;
import com.shakal.rpg.api.mappers.FeatureMapper;
import com.shakal.rpg.api.mappers.LanguageMappers;
import com.shakal.rpg.api.mappers.LevelMapper;
import com.shakal.rpg.api.mappers.MonsterMapper;
import com.shakal.rpg.api.mappers.MonsterTypeMapper;
import com.shakal.rpg.api.mappers.SavingThrowMapper;
import com.shakal.rpg.api.utils.Messages;
import com.shakal.rpg.api.utils.PaginationGenerator;
import com.shakal.rpg.api.validators.CharacterValidator;
import com.shakal.rpg.api.validators.ErrorMessages;





@Service
public class MonsterService implements IMonsterService {

	private MonsterDAO monsterDao;
	private LanguageDAO languageDao;
	private MonsterChallengeLevelDAO challengeLevelDao;
	private DamageTypeDAO damageTypeDao;
	private MonsterTypeDAO monsterTypeDao;
	private MonsterSizeDAO monsterSizeDao;
	private AlignmentDAO alignmentDao;
	private AtributeDAO atributeDao;
	private CreatureAtributeDAO creatureAtributeDao;
	private CreatureResistenceService cretureResisteceService;
	private AttackService attackService;
	private MonsterFeatureDAO monsterFeatureDAO;
	private DiceDAO diceDao;
	private ImageTokenDAO tokenDao;
	@Autowired
	public MonsterService(MonsterDAO monsterDao,LanguageDAO languageDao, 
			MonsterChallengeLevelDAO monsterChallengeDao, DamageTypeDAO damageTypeDao,
			MonsterTypeDAO monsterTypeDao, MonsterSizeDAO monsterSizeDao,
			AlignmentDAO alignmentDao, AtributeDAO atributeDao,
			CreatureAtributeDAO creatureAtributeDao, CreatureResistenceService creatureResistenceService,
			MonsterFeatureDAO monsterFeatureDao, DiceDAO diceDao,AttackService attackService,
			ImageTokenDAO tokenDao) {
		this.monsterDao = monsterDao;
		this.languageDao = languageDao;
		this.challengeLevelDao = monsterChallengeDao;
		this.damageTypeDao = damageTypeDao;
		this.monsterTypeDao = monsterTypeDao;
		this.monsterSizeDao = monsterSizeDao;
		this.alignmentDao = alignmentDao;
		this.atributeDao = atributeDao;
		this.creatureAtributeDao = creatureAtributeDao;
		this.cretureResisteceService = creatureResistenceService;
		this.diceDao = diceDao;
		this.attackService = attackService;
		this.tokenDao = tokenDao;
	}

	@Override
	public MonsterSheetDTO getMonsterSheetById(long id) throws ResourceNotFoundException {
		Monster search = this.monsterDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(Messages.MONSTER_NOT_FOUND));
		
		MonsterSheetDTO result = new MonsterSheetDTO();
		result.setId(search.getId());
		result.setName(search.getRace().getName());
		result.setAlignment(search.getAlignment().getName());
		result.setSize(search.getSize().getName());
		result.setArmorClass(search.getArmorClass());
		result.setLifePoints(search.getBaseLifeDice());
		result.setSpeed(search.getSpeed());
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
				saving -> SavingThrowMapper.entityToDTO(saving,search.getChallengeLevel().getProeficiencyBonus())).collect(Collectors.toList()));
		
		result.setActions(search.getActions().stream().filter(attack -> attack instanceof Attack)
				.filter(legendary -> legendary.isLegendary() == false)
				.map(attack -> AttackMapper.entityToDTO((Attack)attack))
				.collect(Collectors.toList()));
		
		result.setLegendaryActions(search.getLegendaryActions().stream().filter(attack -> attack instanceof Attack)
				.filter(legendary -> legendary.isLegendary())
				.map(attack -> AttackMapper.entityToDTO((Attack)attack))
				.collect(Collectors.toList()));
		
		return result;
	}

	@Override
	public CustomPage<MonsterOverviewDTO> searchMonsterPaged(String name, PaginationFilter filter) {
		Specification<Monster> specification = MonsterSpecification.searchMonster(name);
	    
    	Page<Monster> page = this.monsterDao.findAll(specification,PageRequest.of(filter.getPage() -1, 
				filter.getSize()));
    	return (CustomPage<MonsterOverviewDTO>) PaginationGenerator.convertPage(page,
    			page
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
				
		/*
		Page<MonsterOverviewDTO> page = this.monsterDao.retrieveMonstersAsDTO(PageRequest.of(filter.getPage() -1, 
				filter.getSize()));
    	return (CustomPage<MonsterOverviewDTO>) PaginationGenerator.convertPage(page,page.getContent());
    	*/
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
		result.setDices(this.diceDao.findAll().stream()
				.map(dice -> DiceMapper.diceEntityToDTO(dice))
				.collect(Collectors.toList()));
		return result;
	}

	@Override
	public MonsterCreateDTO insertMonster(MonsterCreateDTO inputDto) throws ResourceNotFoundException, BusinessException {
		ErrorMessages error = new ErrorMessages();
		CharacterValidator.validateToken(inputDto.getImagePath(), error);
		
		//Search entities
		MonsterType typeResult = this.monsterTypeDao.findById(inputDto.getType())
				.orElseThrow(() -> new ResourceNotFoundException(Messages.INVALID_MONSTER_TYPE));
		
		CreatureSize sizeSearch = this.monsterSizeDao.findById(inputDto.getSize())
				.orElseThrow(() -> new ResourceNotFoundException(Messages.INVALID_MONSTER_SIZE));
		
		Alignment alignmentSearch = this.alignmentDao.findById(inputDto.getAlignment())
				.orElseThrow(() -> new ResourceNotFoundException(Messages.INVALID_CREATURE_ALIGNMENT));
		
		CreatureLevel levelSearch = this.challengeLevelDao.findById(inputDto.getLevel())
				.orElseThrow(() -> new ResourceNotFoundException(Messages.INVALID_MONSTER_CHALLENGE_LEVEL));
		
		
		
		//Create the entity and persist
		Monster entity = new Monster();
		entity.setRace(new MonsterRace(inputDto.getRaceName(),
										inputDto.getRaceDescription(),
										typeResult));
		
		entity.setRace(new MonsterRace(inputDto.getRaceName(),
										inputDto.getRaceDescription(),
										typeResult));
		entity.setImagePath(inputDto.getImagePath());
		entity.setSize(sizeSearch);
		entity.setAlignment(alignmentSearch);
		entity.setArmorClass(inputDto.getArmorClass());
		entity.setBaseLifeDice(inputDto.getLifePoints());
		entity.setSpeed(inputDto.getSpeed());
		entity.setChallengeLevel(levelSearch);
		entity.setLanguages(inputDto.getLanguages().stream()
				.map(language -> this.languageDao.getOne(language.getId()))
				.collect(Collectors.toList()));
		
		
		
		//entity.setToken(CreatureMapper.createToken(inputDto.getTokenImageRaw(), error));
		
		if(error.hasError()) {
			throw new BusinessException(error.getMessages().toString());
		}
		/*
		entity.setActions(inputDto.getActions().stream()
				.map(action -> ActionMapper.dtoToGenericEntity(action))
				.collect(Collectors.toList()));
		*/
		
		entity = this.monsterDao.save(entity);
		
		entity.setAtributes(this.mountAtributes(inputDto, entity));
		entity.setResistences(this.cretureResisteceService.mountResistence(inputDto, entity));
		entity = FeatureMapper.saveFeatures(inputDto.getFeatures(),entity);
		this.monsterDao.save(entity);
		this.attackService.mountActions(inputDto.getActions(), entity, false);
		this.attackService.mountActions(inputDto.getLegendaryActions(), entity, true);
		
		
		this.tokenDao.save(CreatureTokenMapper.createToken(inputDto.getTokenImageRaw(),entity));
		return inputDto;
	}
	private List<CreatureAtribute> mountAtributes(MonsterCreateDTO inputDto, Monster monster){
		List<CreatureAtribute> result = new ArrayList<CreatureAtribute>();
		CreatureAtribute force = new CreatureAtribute();
			force.setId(new CreatureAtributeId(1L,monster.getId()));
			force.setAtribute(this.atributeDao.getOne(1L));
			force.setValue(inputDto.getForce());
			force.setModfier(AtributeHelper.calculateAtributeBonus(inputDto.getForce()));
			force.setCreature(monster);
			force.setProeficiency(inputDto.isProeficientForce());
		result.add(force);
		this.creatureAtributeDao.save(force);
		
		CreatureAtribute dex = new CreatureAtribute();
			dex.setId(new CreatureAtributeId(2L,monster.getId()));
			dex.setAtribute(this.atributeDao.getOne(2L));
			dex.setCreature(monster);
			dex.setValue(inputDto.getDexterity());
			dex.setModfier(AtributeHelper.calculateAtributeBonus(inputDto.getDexterity()));
			dex.setProeficiency(inputDto.isProeficientDexterity());
		result.add(dex);
		this.creatureAtributeDao.save(dex);
		
		CreatureAtribute constitution = new CreatureAtribute();
			constitution.setId(new CreatureAtributeId(3L,monster.getId()));
			constitution.setAtribute(this.atributeDao.getOne(3L));
			constitution.setCreature(monster);
			constitution.setValue(inputDto.getConstitution());
			constitution.setModfier(AtributeHelper.calculateAtributeBonus(inputDto.getConstitution()));
			constitution.setProeficiency(inputDto.isProeficientConstitution());
		result.add(constitution);
		this.creatureAtributeDao.save(constitution);
		
		CreatureAtribute inteligence = new CreatureAtribute();
			inteligence.setId(new CreatureAtributeId(4L,monster.getId()));
			inteligence.setAtribute(this.atributeDao.getOne(4L));
			inteligence.setCreature(monster);
			inteligence.setValue(inputDto.getInteligence());
			inteligence.setModfier(AtributeHelper.calculateAtributeBonus(inputDto.getInteligence()));
			inteligence.setProeficiency(inputDto.isProeficientInteligence());
		result.add(inteligence);
		this.creatureAtributeDao.save(inteligence);
		
		CreatureAtribute wisdom = new CreatureAtribute();
			wisdom.setId(new CreatureAtributeId(5L,monster.getId()));
			wisdom.setAtribute(this.atributeDao.getOne(5L));
			wisdom.setCreature(monster);
			wisdom.setValue(inputDto.getWisdom());
			wisdom.setModfier(AtributeHelper.calculateAtributeBonus(inputDto.getWisdom()));
			wisdom.setProeficiency(inputDto.isProeficientConstitution());
		result.add(wisdom);
		this.creatureAtributeDao.save(wisdom);
		
		CreatureAtribute charisma = new CreatureAtribute();
			charisma.setId(new CreatureAtributeId(6L,monster.getId()));
			charisma.setAtribute(this.atributeDao.getOne(6L));
			charisma.setCreature(monster);
			charisma.setValue(inputDto.getCharisma());
			charisma.setModfier(AtributeHelper.calculateAtributeBonus(inputDto.getCharisma()));
			charisma.setProeficiency(inputDto.isProeficientCharisma());
		result.add(charisma);
		this.creatureAtributeDao.save(charisma);
		
		return result;
	}

	@Override
	public CreatureCardDTO getMonsterCardById(Long id) throws ResourceNotFoundException {
		Monster search = this.monsterDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(Messages.MONSTER_NOT_FOUND));
		
		CreatureCardDTO result = new CreatureCardDTO();
		result.setId(search.getId());
		result.setLevel(LevelMapper.entityToInfoDTO(search.getChallengeLevel()));
		result.setLifePoints(search.getBaseLifeDice());
		result.setTotalLifePoints(search.getBaseLifeDice());
		result.setName(search.getRace().getName());
		result.setImagePath(search.getImagePath());
		result.setSpeed(search.getSpeed());
		result.setSize(SizeHelper.getCreatureSizeInSquare( search.getSize()));
		return result;
	}
	
	
}
