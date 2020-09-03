package com.shakal.rpg.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.ICreatureService;
import com.shakal.rpg.api.dto.info.CreatureTokenDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
import com.shakal.rpg.api.mappers.CreatureTokenMapper;
import com.shakal.rpg.api.model.ImageToken;
import com.shakal.rpg.api.repository.CreatureDAO;
import com.shakal.rpg.api.repository.ImageTokenDAO;
import com.shakal.rpg.api.utils.Messages;

@Service
public class CreatureService implements ICreatureService {
	
	private ImageTokenDAO imageTokenDAO;
	private CreatureDAO creatureDAO;
	@Autowired
	public CreatureService(ImageTokenDAO imageTokenDAO,CreatureDAO creatureDAO) {
		this.imageTokenDAO = imageTokenDAO;
		this.creatureDAO = creatureDAO;
	}

	@Override
	public CreatureTokenDTO getCreatureToken(long id) throws ResourceNotFoundException {
		
		ImageToken search = this.imageTokenDAO.retrieveCharacterTokenById(id)
					.orElseThrow(() -> new ResourceNotFoundException(Messages.CHARACTER_NOT_FOUND));
		if(search.getPicture() == null || search.getPicture().length == 0 ) {
			
			CreatureTokenDTO result = new CreatureTokenDTO();
			result.setId(id);
			result.setPicture(search.getCreature().getImagePath());
			return result;
		}else {
			return CreatureTokenMapper.mapEntityToDTO(search);
		}
				
		
	}

}
