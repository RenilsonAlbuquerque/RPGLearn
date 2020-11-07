package com.shakal.rpg.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.ICharacterService;
import com.shakal.rpg.api.contracts.service.ICombatService;
import com.shakal.rpg.api.contracts.service.IUserService;
import com.shakal.rpg.api.dto.combat.CardPositionDTO;
import com.shakal.rpg.api.dto.combat.CreatureCardDTO;
import com.shakal.rpg.api.dto.create.CharacterCreateDTO;
import com.shakal.rpg.api.dto.create.CharacterCreateInputDTO;
import com.shakal.rpg.api.dto.filter.UserSheetFIlterDTO;
import com.shakal.rpg.api.dto.info.CharacterGeneralInfoDTO;
import com.shakal.rpg.api.dto.info.CharacterSheetDTO;
import com.shakal.rpg.api.dto.info.LevelDTO;
import com.shakal.rpg.api.exception.BusinessException;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
import com.shakal.rpg.api.helpers.AtributeHelper;
import com.shakal.rpg.api.helpers.CharacterHelper;
import com.shakal.rpg.api.helpers.CombatHelper;
import com.shakal.rpg.api.mappers.CharacterMapper;
import com.shakal.rpg.api.mappers.ClassMapper;
import com.shakal.rpg.api.mappers.CreatureMapper;
import com.shakal.rpg.api.mappers.CreatureTokenMapper;
import com.shakal.rpg.api.mappers.RaceMapper;
import com.shakal.rpg.api.repository.AlignmentDAO;
import com.shakal.rpg.api.repository.AtributeDAO;
import com.shakal.rpg.api.repository.CharacterClassLevelDAO;
import com.shakal.rpg.api.repository.CharacterDAO;
import com.shakal.rpg.api.repository.ClassDAO;
import com.shakal.rpg.api.repository.ClassLevelDAO;
import com.shakal.rpg.api.repository.CreatureAtributeDAO;
import com.shakal.rpg.api.repository.ImageTokenDAO;
import com.shakal.rpg.api.repository.LanguageDAO;
import com.shakal.rpg.api.repository.ProeficiencyDAO;
import com.shakal.rpg.api.repository.RaceDAO;
import com.shakal.rpg.api.repository.UserStoryDAO;
import com.shakal.rpg.api.utils.Messages;
import com.shakal.rpg.api.validators.CharacterValidator;
import com.shakal.rpg.api.validators.ErrorMessages;
import com.shakal.rpg.api.model.Alignment;
import com.shakal.rpg.api.model.Atribute;
import com.shakal.rpg.api.model.Race;
import com.shakal.rpg.api.model.character.Class;
import com.shakal.rpg.api.model.character.ClassLevel;
import com.shakal.rpg.api.model.creature.Proeficiency;
import com.shakal.rpg.api.model.embedded.CreatureAtributeId;
import com.shakal.rpg.api.model.character.Character;
import com.shakal.rpg.api.model.character.CharacterRaceAtributeBonus;
import com.shakal.rpg.api.model.relation.CreatureAtribute;
import com.shakal.rpg.api.model.relation.UserStory;

@Service
public class CharacterService implements ICharacterService{

	private IUserService userService;
	private ICombatService combatService;
	private CharacterDAO characterDao;
	private AlignmentDAO alignmentDao;
	private UserStoryDAO userStoryDao;
	private RaceDAO raceDao;
	private ClassDAO classDao;
	private ClassLevelDAO classLevelDAO;
	private CharacterClassLevelDAO characterClassLevelDAO;
	private CreatureAtributeDAO creatureAtributeDao;
	private ImageTokenDAO tokenDao;
	private AtributeDAO atributeDao;
	private LanguageDAO languageDao;
	private ProeficiencyDAO proeficiencyDao;
	
	@Autowired
	public CharacterService(IUserService userService,
			CharacterDAO characterDao,AlignmentDAO alignmentDao,
			UserStoryDAO userStoryDao,RaceDAO raceDao,
			ClassDAO classDao, ClassLevelDAO classLevelDAO,
			CharacterClassLevelDAO characterClassLevelDAO,
			CreatureAtributeDAO creatureAtributeDao,
			ImageTokenDAO tokenDao,
			AtributeDAO atributeDao,LanguageDAO languageDao,
			ProeficiencyDAO proeficiencyDao) {
		this.userService = userService;
		this.characterDao = characterDao;
		this.alignmentDao = alignmentDao;
		this.userStoryDao = userStoryDao;
		this.raceDao = raceDao;
		this.classDao = classDao;
		this.classLevelDAO = classLevelDAO;
		this.characterClassLevelDAO = characterClassLevelDAO;
		this.creatureAtributeDao = creatureAtributeDao;
		this.tokenDao = tokenDao;
		this.atributeDao = atributeDao;
		this.languageDao = languageDao;
		this.proeficiencyDao = proeficiencyDao;
	}
	
	@Override
	public boolean createCharacterInStory(CharacterCreateDTO inputDto) throws BusinessException {
		ErrorMessages error = new ErrorMessages();
		CharacterValidator.ValidateDTO(inputDto, error);
		
		
		Optional<Alignment> alignmentSearch = this.alignmentDao.findById(inputDto.getAlignment());
		Optional<Race> raceSearch = this.raceDao.findById(inputDto.getRace());
		Optional<Class> classSearch = this.classDao.findById(inputDto.getClasss());
		Optional<ClassLevel> classLevelSearch = this.classLevelDAO.retrieveFirstLevelOfClass(inputDto.getClasss(), 4);
		CharacterValidator.ValidateRecoveryEntities(error, alignmentSearch, raceSearch);
		CharacterValidator.ValidateRecoveryClassEntities(error, classLevelSearch, classSearch);
		CharacterValidator.validateToken(inputDto.getImagePath(), error);
		
		
		if(error.hasError()) {
			throw new BusinessException(error.getMessages().toString());
		}
		
		Character entity = new Character();
		entity.setImagePath(inputDto.getImagePath());
		entity.setName(inputDto.getName());
		entity.setAge(inputDto.getAge());
		entity.setHeight(inputDto.getHeight());
		entity.setAlignment(alignmentSearch.get());
		entity.setLifePoints(CharacterHelper.calculateLifePoints(classSearch.get().getLifeDice()));
		entity.setSpeed(raceSearch.get().getSpeed());
		entity.setRace(raceSearch.get());
		entity.setLanguages(raceSearch.get().getLangauges().stream()
				.map(language -> this.languageDao.getOne(language.getId()))
				.collect(Collectors.toList()));
		
		entity.setProeficiencies(inputDto.getProeficiencies().stream()
				.map(proeficiency -> this.proeficiencyDao.findById(Long.valueOf(proeficiency)).get())
				.collect(Collectors.toList()));
		
		
		entity = this.characterDao.save(entity);
		this.userService.setCharacterToUserInStory(inputDto.getStoryId(),
				inputDto.getUserId(), entity);
		this.buildCharacterAtributes(inputDto,entity,raceSearch.get(), classSearch.get());
		this.characterClassLevelDAO.save(ClassMapper.createFistLevelOfPlayer(classLevelSearch.get(),entity));
		this.tokenDao.save(CreatureTokenMapper.createToken(inputDto.getTokenImageRaw(),entity));
		return true;
	}

	@Override
	public CharacterGeneralInfoDTO getCharacterSheetByUserInStory(UserSheetFIlterDTO filter) throws ResourceNotFoundException {
		CharacterGeneralInfoDTO result = new CharacterGeneralInfoDTO();
		UserStory search = this.userStoryDao.retrieveCharacterOfUserInStory
				(filter.getUserId(), filter.getStoryId())
				.orElseThrow(() -> new ResourceNotFoundException(Messages.CHARACTER_NOT_FOUND));
	
		
		Character ch = search.getCharacter();
		if(ch == null) {
			throw new ResourceNotFoundException("Sem personagem nessa hist�ria");
		}
		result.setCharacterSheet(CharacterMapper.entityToInfo(ch));
		result.setCharacterToken(this.initalizePlayerTokenInStory(result.getCharacterSheet(),filter.getUserId()));
		return result;
	}

	@Override
	public CharacterCreateInputDTO getCharacterCreationMetadata() {
		CharacterCreateInputDTO result = new CharacterCreateInputDTO();
		result.setAlignments(this.alignmentDao.findAll().stream()
				.map(alignment -> CreatureMapper.alignmentEntityToDTO(alignment))
				.collect(Collectors.toList()));
		result.setRaces(this.raceDao.findAll().stream()
				.map(race -> RaceMapper.mapRaceEntityToMetadataDTO(race) )
				.collect(Collectors.toList()));
		result.setClasses(this.classDao.findAll().stream()
				.map(clas -> ClassMapper.mapEntityToCreateMetadataDTO(clas))
				.collect(Collectors.toList()));
		return result;
	}
	private CreatureCardDTO initalizePlayerTokenInStory(CharacterSheetDTO characterSheet,long playerId) {
		
		CreatureCardDTO result = new CreatureCardDTO();
		result.setId(characterSheet.getId());
		result.setName(characterSheet.getName());
		result.setLifePoints(characterSheet.getLifePoints().getTotalLifePoints());
		result.setLevel(new LevelDTO(2,450));
		result.setTotalLifePoints(characterSheet.getLifePoints().getTotalLifePoints());
		result.setImagePath(characterSheet.getImagePath());
		result.setLifePercent(CombatHelper.calculateLifePercent(characterSheet.getLifePoints().getTotalLifePoints(), characterSheet.getLifePoints().getTotalLifePoints()));
		result.setSpeed(characterSheet.getSpeed());
		result.setPlayerId(playerId);
		result.setPosition(new CardPositionDTO(3,4));
		result.setSize(1);
		return result;
	}

	@Override
	public CharacterSheetDTO getCharacterSheet(Long id) throws ResourceNotFoundException {
		Character search = this.characterDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(Messages.CHARACTER_NOT_FOUND));
		CharacterSheetDTO result = CharacterMapper.entityToInfo(search);
		return result;
	}
	
	private void buildCharacterAtributes(CharacterCreateDTO inputDto, Character character,Race race,
			Class clasS) {
		int strengthBonus = 0;
		int dexterityBonus = 0;
		int constitutionBonus = 0;
		int intelligenceBonus = 0;
		int wisdomBonus = 0;
		int charismaBonus = 0 ;
		boolean strengthProf = false;
		boolean dexProf = false;
		boolean conProf = false;
		boolean intProf = false;
		boolean wisProf = false;
		boolean carProf = false;
		
		for(CharacterRaceAtributeBonus at: race.getAtributeBonus()) {
			if(at.getAtribute().getId() == 1) {
				strengthBonus += at.getBonus();
				
			}
			if(at.getAtribute().getId() == 2) {
				dexterityBonus += at.getBonus();
			}
			if(at.getAtribute().getId() == 3) {
				constitutionBonus += at.getBonus();
			}
			if(at.getAtribute().getId() == 4) {
				intelligenceBonus += at.getBonus();
			}
			if(at.getAtribute().getId() == 5) {
				wisdomBonus += at.getBonus();
			}
			if(at.getAtribute().getId() == 6) {
				charismaBonus += at.getBonus();
			}
		}
		for(Atribute st: clasS.getSavingThrows()) {
			if(st.getId() == 1) {
				strengthProf = true;
			}
			if(st.getId() == 2) {
				dexProf = true;
			}
			if(st.getId() == 3) {
				conProf = true;
			}
			if(st.getId() == 4) {
				intProf = true;
			}
			if(st.getId() == 5) {
				wisProf = true;
			}
			if(st.getId() == 6) {
				carProf = true;
			}
		}
		
		CreatureAtribute strenght = new CreatureAtribute();
		CreatureAtributeId strenghtId = new CreatureAtributeId();
		strenghtId.setAtributeId(1L);
		strenghtId.setCreatureId(character.getId());
		strenght.setValue(inputDto.getStrength() + strengthBonus);
		strenght.setModfier(AtributeHelper.calculateAtributeBonus(strenght.getValue()));
		strenght.setProeficiency(strengthProf);
		strenght.setCreature(character);
		strenght.setAtribute(this.atributeDao.getOne(1L));
		strenght.setId(strenghtId);
		this.creatureAtributeDao.save(strenght);
		
		
		CreatureAtribute dexterity = new CreatureAtribute();
		CreatureAtributeId dexterityId = new CreatureAtributeId();
		dexterityId.setAtributeId(2L);
		dexterityId.setCreatureId(character.getId());
		dexterity.setValue(inputDto.getDexterity() + dexterityBonus);
		dexterity.setModfier(AtributeHelper.calculateAtributeBonus(dexterity.getValue()));
		dexterity.setProeficiency(dexProf);
		dexterity.setCreature(character);
		dexterity.setAtribute(this.atributeDao.getOne(2L));
		dexterity.setId(dexterityId);
		this.creatureAtributeDao.save(dexterity);
		
		CreatureAtribute constitution = new CreatureAtribute();
		CreatureAtributeId constitutionId = new CreatureAtributeId();
		constitutionId.setAtributeId(3L);
		constitutionId.setCreatureId(character.getId());
		constitution.setValue(inputDto.getConstitution() + constitutionBonus);
		constitution.setModfier(AtributeHelper.calculateAtributeBonus(constitution.getValue()));
		constitution.setProeficiency(conProf);
		constitution.setCreature(character);
		constitution.setAtribute(this.atributeDao.getOne(3L));
		constitution.setId(constitutionId);
		this.creatureAtributeDao.save(constitution);
		
		CreatureAtribute intelligence = new CreatureAtribute();
		CreatureAtributeId intelligenceId = new CreatureAtributeId();
		intelligenceId.setAtributeId(4L);
		intelligenceId.setCreatureId(character.getId());
		intelligence.setValue(inputDto.getInteligence() + intelligenceBonus);
		intelligence.setModfier(AtributeHelper.calculateAtributeBonus(intelligence.getValue()));
		intelligence.setProeficiency(intProf);
		intelligence.setCreature(character);
		intelligence.setAtribute(this.atributeDao.getOne(4L));
		intelligence.setId(intelligenceId);
		this.creatureAtributeDao.save(intelligence);
		
		CreatureAtribute wisdom = new CreatureAtribute();
		CreatureAtributeId wisdomId = new CreatureAtributeId();
		wisdomId.setAtributeId(5L);
		wisdomId.setCreatureId(character.getId());
		wisdom.setValue(inputDto.getWisdom() + wisdomBonus);
		wisdom.setModfier(AtributeHelper.calculateAtributeBonus(wisdom.getValue()));
		wisdom.setProeficiency(wisProf);
		wisdom.setCreature(character);
		wisdom.setAtribute(this.atributeDao.getOne(5L));
		wisdom.setId(wisdomId);
		this.creatureAtributeDao.save(wisdom);
		
		CreatureAtribute charisma = new CreatureAtribute();
		CreatureAtributeId charismaId = new CreatureAtributeId();
		charismaId.setAtributeId(6L);
		charismaId.setCreatureId(character.getId());
		charisma.setValue(inputDto.getCharisma() + charismaBonus);
		charisma.setModfier(AtributeHelper.calculateAtributeBonus(charisma.getValue()));
		charisma.setProeficiency(carProf);
		charisma.setCreature(character);
		charisma.setAtribute(this.atributeDao.getOne(6L));
		charisma.setId(charismaId);
		this.creatureAtributeDao.save(charisma);
		
	}
}
