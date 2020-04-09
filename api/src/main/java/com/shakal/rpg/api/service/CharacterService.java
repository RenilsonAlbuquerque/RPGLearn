package com.shakal.rpg.api.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.ICharacterService;
import com.shakal.rpg.api.contracts.service.ICombatService;
import com.shakal.rpg.api.contracts.service.IUserService;
import com.shakal.rpg.api.dto.combat.CardPositionDTO;
import com.shakal.rpg.api.dto.combat.PlayerCardDTO;
import com.shakal.rpg.api.dto.create.CharacterCreateDTO;
import com.shakal.rpg.api.dto.create.CharacterCreateInputDTO;
import com.shakal.rpg.api.dto.filter.UserSheetFIlterDTO;
import com.shakal.rpg.api.dto.info.CharacterGeneralInfoDTO;
import com.shakal.rpg.api.dto.info.CharacterSheetDTO;
import com.shakal.rpg.api.dto.info.LevelDTO;
import com.shakal.rpg.api.exception.BusinessException;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
import com.shakal.rpg.api.helpers.CombatHelper;
import com.shakal.rpg.api.mappers.CharacterMapper;
import com.shakal.rpg.api.mappers.ClassMapper;
import com.shakal.rpg.api.mappers.CreatureMapper;
import com.shakal.rpg.api.mappers.RaceMapper;
import com.shakal.rpg.api.repository.AlignmentDAO;
import com.shakal.rpg.api.repository.CharacterDAO;
import com.shakal.rpg.api.repository.ClassDAO;
import com.shakal.rpg.api.repository.RaceDAO;
import com.shakal.rpg.api.repository.UserStoryDAO;
import com.shakal.rpg.api.utils.Messages;
import com.shakal.rpg.api.validators.CharacterValidator;
import com.shakal.rpg.api.validators.ErrorMessages;
import com.shakal.rpg.api.model.Alignment;
import com.shakal.rpg.api.model.Race;
import com.shakal.rpg.api.model.character.Character;
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
	
	@Autowired
	public CharacterService(IUserService userService,ICombatService combatService,
			CharacterDAO characterDao,AlignmentDAO alignmentDao,
			UserStoryDAO userStoryDao,RaceDAO raceDao,
			ClassDAO classDao) {
		this.userService = userService;
		this.combatService = combatService;
		this.characterDao = characterDao;
		this.alignmentDao = alignmentDao;
		this.userStoryDao = userStoryDao;
		this.raceDao = raceDao;
		this.classDao = classDao;
	}
	
	@Override
	public boolean createCharacterInStory(CharacterCreateDTO inputDto) throws BusinessException {
		ErrorMessages error = new ErrorMessages();
		CharacterValidator.ValidateDTO(inputDto, error);
		
		Optional<Alignment> alignmentSearch = this.alignmentDao.findById(inputDto.getAlignment());
		Optional<Race> raceSearch = this.raceDao.findById(inputDto.getRace());
		
		CharacterValidator.ValidateRecoveryEntities(error, alignmentSearch, raceSearch);
		
		if(error.hasError()) {
			throw new BusinessException(error.getMessages().toString());
		}
		
		Character entity = new Character();
		entity.setImagePath(inputDto.getImagePath());
		entity.setName(inputDto.getName());
		entity.setAge(inputDto.getAge());
		entity.setHeight(inputDto.getHeight());
		entity.setAlignment(alignmentSearch.get());
		entity.setSpeed(raceSearch.get().getSpeed());
		
		this.characterDao.save(entity);
		this.userService.setCharacterToUserInStory(inputDto.getStoryId(),
				inputDto.getUserId(), entity);
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
			throw new ResourceNotFoundException("Sem personagem nessa história");
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
	private PlayerCardDTO initalizePlayerTokenInStory(CharacterSheetDTO characterSheet,long playerId) {
		
		PlayerCardDTO result = new PlayerCardDTO();
		result.setId(characterSheet.getId());
		result.setName(characterSheet.getName());
		result.setLifePoints(characterSheet.getTotalLifePoints());
		result.setLevel(new LevelDTO());
		result.setTotalLifePoints(characterSheet.getTotalLifePoints());
		result.setImagePath(characterSheet.getImagePath());
		result.setLifePercent(CombatHelper.calculateLifePercent(characterSheet.getTotalLifePoints(), characterSheet.getTotalLifePoints()));
		result.setSpeed(characterSheet.getSpeed());
		result.setPlayerId(playerId);
		result.setPosition(new CardPositionDTO(3,4));
		return result;
	}
}
