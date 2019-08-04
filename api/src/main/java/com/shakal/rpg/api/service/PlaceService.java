package com.shakal.rpg.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.IPlaceService;
import com.shakal.rpg.api.dto.info.PlaceInfoDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
import com.shakal.rpg.api.mappers.StoryMapper;
import com.shakal.rpg.api.model.Place;
import com.shakal.rpg.api.repository.PlaceDAO;
import com.shakal.rpg.api.utils.Messages;

@Service
public class PlaceService implements IPlaceService{

	private PlaceDAO placeDao;
	
	@Autowired
	public PlaceService(PlaceDAO placeDao) {
		this.placeDao = placeDao;
	}
	
	@Override
	public PlaceInfoDTO getStoryById(long id) throws ResourceNotFoundException {
		Place place = this.placeDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(Messages.STORY_NOT_FOUND));
		return StoryMapper.placeEntityToDto(place);
	}

}
