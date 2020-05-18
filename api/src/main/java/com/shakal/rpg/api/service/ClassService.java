package com.shakal.rpg.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.IClassService;
import com.shakal.rpg.api.dto.create.ClassDetailInputDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
import com.shakal.rpg.api.mappers.ClassMapper;
import com.shakal.rpg.api.model.character.Class;
import com.shakal.rpg.api.repository.ClassDAO;
import com.shakal.rpg.api.utils.Messages;


@Service
public class ClassService implements IClassService{
	private ClassDAO classDAO;
	
	
	@Autowired
	public ClassService(ClassDAO classDAO) {
		this.classDAO = classDAO;
	}


	@Override
	public ClassDetailInputDTO getClassMetadata(Long raceId) throws ResourceNotFoundException {
		Class search = this.classDAO.findById(raceId)
				.orElseThrow(() -> new ResourceNotFoundException(Messages.STORY_NOT_FOUND));
		return ClassMapper.mapEntityToCreateMetadataDetail(search);
	}

}
