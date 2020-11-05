package com.shakal.rpg.api.service;

import java.awt.Dimension;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.IPlaceService;
import com.shakal.rpg.api.dto.create.PlaceCreateDTO;
import com.shakal.rpg.api.dto.filter.CustomPage;
import com.shakal.rpg.api.dto.info.PlaceInfoDTO;
import com.shakal.rpg.api.dto.overview.MonsterOverviewDTO;
import com.shakal.rpg.api.dto.overview.PlaceOverviewDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
import com.shakal.rpg.api.helpers.FileHelper;
import com.shakal.rpg.api.mappers.MonsterMapper;
import com.shakal.rpg.api.mappers.PlaceMapper;
import com.shakal.rpg.api.mappers.StoryMapper;
import com.shakal.rpg.api.model.Monster;
import com.shakal.rpg.api.model.Place;
import com.shakal.rpg.api.model.Story;
import com.shakal.rpg.api.repository.PlaceDAO;
import com.shakal.rpg.api.repository.StoryDAO;
import com.shakal.rpg.api.utils.Messages;
import com.shakal.rpg.api.utils.PaginationGenerator;
import com.shakal.rpg.api.utils.Constants;

@Service
public class PlaceService implements IPlaceService{

	private PlaceDAO placeDao;
	private StoryDAO storyDao;
	
	@Autowired
	public PlaceService(PlaceDAO placeDao, StoryDAO storyDao) {
		this.placeDao = placeDao;
		this.storyDao = storyDao;
	}
	
	@Override
	public PlaceInfoDTO getPlaceById(long id) throws ResourceNotFoundException {
		Place place = this.placeDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(Messages.STORY_NOT_FOUND));
		
		try {
			place.setMap(FileHelper.convertImageToBase64(Constants.MAPS_IMAGES_PATH + place.getMap()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return StoryMapper.placeEntityToDto(place);
	}

	@Override
	public List<PlaceOverviewDTO> getPlacesListByStoryId(long id) throws ResourceNotFoundException {
		
    	return (List<PlaceOverviewDTO>) 
    			placeDao.findAll()
        		.stream()
        		.map(place -> PlaceMapper.entityToOverview(place))
                .collect(Collectors.toList());
	}

	@Override
	public PlaceOverviewDTO createPlace(PlaceCreateDTO placeCreate) throws ResourceNotFoundException{
		
		Story story = this.storyDao.findById(placeCreate.getStoryId())
				.orElseThrow(() -> new ResourceNotFoundException(Messages.STORY_NOT_FOUND));
		Place entity = new Place();
		entity.setName(placeCreate.getName());
		entity.setBackground(placeCreate.getBackground());
		entity.setMap("");
		entity.setxDimension(placeCreate.getxDimension());
		entity.setyDimension(placeCreate.getyDimension());
		entity.setSquareDimension(placeCreate.getSquareDimension());
		entity.setNaturalHeight(200.0d);
		entity.setSquareSizeCm(placeCreate.getSquareSizeCm());
		entity.setStory(story);
		entity = this.placeDao.save(entity);
		String fileName = "map" + entity.getId()+ ".jpg";
		Dimension dimension = new Dimension();
		try {
			dimension =FileHelper.createFileAndPersist(Constants.MAPS_IMAGES_PATH, placeCreate.getMap(),fileName );
		} catch (IOException e) {
			e.printStackTrace();
		}
		entity.setMap(fileName);
		entity.setNaturalHeight(dimension.getHeight());
		entity.setNaturalWidth(dimension.getWidth());
		entity = this.placeDao.save(entity);
		return PlaceMapper.entityToOverview(entity);
	}
	
	


}
