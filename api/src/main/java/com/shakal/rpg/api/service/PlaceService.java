package com.shakal.rpg.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.IPlaceService;
import com.shakal.rpg.api.dto.info.PlaceInfoDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
import com.shakal.rpg.api.mappers.StoryMapper;
import com.shakal.rpg.api.model.mongo.Place;
import com.shakal.rpg.api.repository.PlaceDAO;
import com.shakal.rpg.api.repository.mongo.PlaceRepository;
import com.shakal.rpg.api.utils.Messages;

@Service
public class PlaceService implements IPlaceService{

	private PlaceRepository placeDao;
	
	@Autowired
	public PlaceService(PlaceRepository placeDao) {
		this.placeDao = placeDao;
	}
	
	@Override
	public PlaceInfoDTO getStoryById(String id) throws ResourceNotFoundException {
		Place place = this.placeDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(Messages.STORY_NOT_FOUND));
		return StoryMapper.placeEntityToDto(place);
	}

}
