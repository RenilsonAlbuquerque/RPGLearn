package com.shakal.rpg.api.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.IStoryService;
import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.create.PlaceCreateDTO;
import com.shakal.rpg.api.dto.create.StoryCreateDTO;
import com.shakal.rpg.api.dto.create.StoryCreateInputDTO;
import com.shakal.rpg.api.dto.filter.CustomPage;
import com.shakal.rpg.api.dto.filter.PaginationFilter;
import com.shakal.rpg.api.dto.info.StoryInfoDTO;
import com.shakal.rpg.api.dto.overview.StoryOverviewDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
import com.shakal.rpg.api.mappers.StoryMapper;
import com.shakal.rpg.api.mappers.UserMapper;
import com.shakal.rpg.api.model.Place;
import com.shakal.rpg.api.model.Story;
import com.shakal.rpg.api.model.User;
import com.shakal.rpg.api.model.embedded.UserStoryId;
import com.shakal.rpg.api.model.relation.UserStory;
import com.shakal.rpg.api.repository.PlaceDAO;
import com.shakal.rpg.api.repository.StoryDAO;
import com.shakal.rpg.api.repository.UserDAO;
import com.shakal.rpg.api.repository.UserStoryDAO;
import com.shakal.rpg.api.utils.Messages;
import com.shakal.rpg.api.utils.PaginationGenerator;

@Service
public class StoryService implements IStoryService {

	
	private StoryDAO storyRepository;
	private PlaceDAO placeRepository;
	private UserDAO userDao;
	private UserStoryDAO userStoryDao;
	
	@Autowired
	public StoryService(StoryDAO storyRepository, UserDAO userDao,
			UserStoryDAO userStoryDao,PlaceDAO placeDAO) {
		this.storyRepository = storyRepository;
		this.userDao = userDao;
		this.userStoryDao = userStoryDao;
		this.placeRepository = placeDAO;
	}
	
	@Override
	public StoryCreateDTO insertStory(StoryCreateDTO inputDto) throws ResourceNotFoundException {
		Story entity = new Story();
		entity.setName(inputDto.getName());
		entity.setBackground(inputDto.getBackground());
		entity.setFolderImage(inputDto.getFolderImage());
		
		
		
		entity = this.storyRepository.save(entity);
		/*
		entity.setPlaces(inputDto.getPlaces().stream()
				.map(place -> StoryMapper.placeDtoToEntity(place))
				.collect(Collectors.toList()));
				*/
		this.setPlaces(entity, inputDto.getPlaces());
		this.setUsersInStory(entity, inputDto.getUsers());
		this.storyRepository.save(entity);
		return inputDto;
	}

	@Override
	public CustomPage<StoryOverviewDTO> listsStoriesPaged(PaginationFilter filter) {
		Page<Story> page = this.storyRepository.findAll(PageRequest.of(filter.getPage() -1, 
				filter.getSize()));
		return (CustomPage<StoryOverviewDTO>) PaginationGenerator.convertPage(page,page
        		.stream().map( story -> StoryMapper.entityTOOverview(story))
                .collect(Collectors.toList()));
		
	}

	@Override
	public StoryInfoDTO getStoryById(long id) throws ResourceNotFoundException {
		Story story = this.storyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(Messages.STORY_NOT_FOUND));
		return StoryMapper.entityToInfo(story);
	}

	@Override
	public StoryCreateInputDTO getStoryInfoToCreate() {
		StoryCreateInputDTO result = new StoryCreateInputDTO();
		result.setUsers(this.userDao.findAll().stream()
				.map(user -> UserMapper.entityToKeyValue(user)).collect(Collectors.toList()));
		return result;
	}
	private void setUsersInStory(Story story, List<KeyValueDTO> users) {
		for(KeyValueDTO user: users) {
			User userEntity = this.userDao.getOne(user.getId());
			UserStory userStory = new UserStory();
			userStory.setId(new UserStoryId(user.getId(),story.getId()));
			userStory.setStory(story);
			userStory.setUser(userEntity);
			this.userStoryDao.save(userStory);
		}
	}

	@Override
	public CustomPage<StoryOverviewDTO> listsStoriesByUserIdPaged(PaginationFilter filter, long userId) {
		Page<StoryOverviewDTO> page = this.userStoryDao.retrieveStoriesAsDTO(PageRequest.of(filter.getPage() -1, 
				filter.getSize()));
		return (CustomPage<StoryOverviewDTO>) PaginationGenerator.convertPage(page);
	}
	private void setPlaces(Story story,List<PlaceCreateDTO> placeInput) {
		for(PlaceCreateDTO placeDto: placeInput) {
			Place entity = StoryMapper.placeDtoToEntity(placeDto);
			entity.setStory(story);
			this.placeRepository.save(entity);
		} 
	}

}
