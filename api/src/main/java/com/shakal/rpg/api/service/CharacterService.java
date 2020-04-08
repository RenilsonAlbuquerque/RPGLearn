package com.shakal.rpg.api.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.ICharacterService;
import com.shakal.rpg.api.contracts.service.IUserService;
import com.shakal.rpg.api.dto.create.CharacterCreateDTO;
import com.shakal.rpg.api.dto.create.CharacterCreateInputDTO;
import com.shakal.rpg.api.dto.filter.UserSheetFIlterDTO;
import com.shakal.rpg.api.dto.info.CharacterInfoDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
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
import com.shakal.rpg.api.model.Alignment;
import com.shakal.rpg.api.model.character.Character;
import com.shakal.rpg.api.model.relation.UserStory;

@Service
public class CharacterService implements ICharacterService{

	private IUserService userService;
	private CharacterDAO characterDao;
	private AlignmentDAO alignmentDao;
	private UserStoryDAO userStoryDao;
	private RaceDAO raceDao;
	private ClassDAO classDao;
	
	@Autowired
	public CharacterService(IUserService userService,CharacterDAO characterDao,
			AlignmentDAO alignmentDao,UserStoryDAO userStoryDao,RaceDAO raceDao,
			ClassDAO classDao) {
		this.userService = userService;
		this.characterDao = characterDao;
		this.alignmentDao = alignmentDao;
		this.userStoryDao = userStoryDao;
		this.raceDao = raceDao;
		this.classDao = classDao;
	}
	
	@Override
	public boolean createCharacterInStory(CharacterCreateDTO inputDto) throws ResourceNotFoundException {
		Alignment alignmentSearch = this.alignmentDao.findById(inputDto.getAlignment())
				.orElseThrow(() -> new ResourceNotFoundException(Messages.INVALID_CREATURE_ALIGNMENT));
		
		Character entity = new Character();
		entity.setImagePath(inputDto.getImagePath());
		entity.setName(inputDto.getName());
		entity.setAge(inputDto.getAge());
		entity.setHeight(inputDto.getHeight());
		entity.setAlignment(alignmentSearch);
		
		this.characterDao.save(entity);
		this.userService.setCharacterToUserInStory(inputDto.getStoryId(),
				inputDto.getUserId(), entity);
		return true;
	}

	@Override
	public CharacterInfoDTO getCharacterSheetByUserInStory(UserSheetFIlterDTO filter) throws ResourceNotFoundException {
		
		UserStory search = this.userStoryDao.retrieveCharacterOfUserInStory
				(filter.getUserId(), filter.getStoryId())
				.orElseThrow(() -> new ResourceNotFoundException(Messages.CHARACTER_NOT_FOUND));
	
		
		Character ch = search.getCharacter();
		if(ch == null) {
			throw new ResourceNotFoundException("Sem personagem nessa história");
		}
		return CharacterMapper.entityToInfo(ch);
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

}
