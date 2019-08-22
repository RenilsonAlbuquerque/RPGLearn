package com.shakal.rpg.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.ICharacterService;
import com.shakal.rpg.api.contracts.service.IUserService;
import com.shakal.rpg.api.dto.create.CharacterCreateDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
import com.shakal.rpg.api.repository.AlignmentDAO;
import com.shakal.rpg.api.repository.CharacterDAO;
import com.shakal.rpg.api.utils.Messages;
import com.shakal.rpg.api.model.Alignment;
import com.shakal.rpg.api.model.character.Character;

@Service
public class CharacterService implements ICharacterService{

	private IUserService userService;
	private CharacterDAO characterDao;
	private AlignmentDAO alignmentDao;
	
	@Autowired
	public CharacterService(IUserService userService,CharacterDAO characterDao,
			AlignmentDAO alignmentDao) {
		this.userService = userService;
		this.characterDao = characterDao;
		this.alignmentDao = alignmentDao;
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

}
