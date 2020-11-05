package com.shakal.rpg.api.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.IPlaceMarkService;
import com.shakal.rpg.api.dto.create.PlaceMarkCreateDTO;
import com.shakal.rpg.api.dto.info.PlaceMarkInfo;
import com.shakal.rpg.api.dto.overview.PlaceMarkOverviewDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
import com.shakal.rpg.api.mappers.PlaceMarkMapper;
import com.shakal.rpg.api.model.Place;
import com.shakal.rpg.api.model.place.PlaceMark;
import com.shakal.rpg.api.repository.PlaceDAO;
import com.shakal.rpg.api.repository.PlaceMarkDAO;
import com.shakal.rpg.api.utils.Messages;

@Service
public class PlaceMarkService implements IPlaceMarkService {
	
	
	private PlaceMarkDAO placeMarkDao;
	private PlaceDAO placeDao;
	
	@Autowired
	public PlaceMarkService(PlaceMarkDAO placeMarkDao,PlaceDAO placeDao) {
		this.placeMarkDao = placeMarkDao;
		this.placeDao = placeDao;
	}

	@Override
	public PlaceMarkInfo getPlaceMarkInfoById(long id) throws ResourceNotFoundException {
		PlaceMark placeMark = this.placeMarkDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(Messages.STORY_NOT_FOUND));
		return PlaceMarkMapper.entityToInfo(placeMark);
		
		
	}

	@Override
	public List<PlaceMarkOverviewDTO> getAllPlaceMarksOfPlace(long placeId) throws ResourceNotFoundException {
		Place place = this.placeDao.findById(placeId)
				.orElseThrow(() -> new ResourceNotFoundException(Messages.PLACE_NOT_FOUND));
		return place.getMarks()
		.stream()
		.map(mark -> PlaceMarkMapper.entityToOverview(mark))
        .collect(Collectors.toList());
	}

	@Override
	public PlaceMarkCreateDTO createPlaceMark(PlaceMarkCreateDTO placeMarkCreateDTO) throws ResourceNotFoundException {
		Place place = this.placeDao.findById(placeMarkCreateDTO.getPlaceId())
				.orElseThrow(() -> new ResourceNotFoundException(Messages.PLACE_NOT_FOUND));
		PlaceMark entity = new PlaceMark();
		entity.setName(placeMarkCreateDTO.getName());
		entity.setDescription(placeMarkCreateDTO.getDescription());
		entity.setCoordinateX(placeMarkCreateDTO.getCoordinateX());
		entity.setCoordinateY(placeMarkCreateDTO.getCoordinateY());
		entity.setPlace(place);
		this.placeMarkDao.save(entity);
		return placeMarkCreateDTO;
	}
	
	

}
