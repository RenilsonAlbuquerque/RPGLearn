package com.shakal.rpg.api.service;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.shakal.rpg.api.contracts.service.IStoryService;
import com.shakal.rpg.api.dto.create.StoryCreateDTO;
import com.shakal.rpg.api.dto.filter.CustomPage;
import com.shakal.rpg.api.dto.filter.PaginationFilter;

import com.shakal.rpg.api.dto.overview.MonsterOverviewDTO;
import com.shakal.rpg.api.dto.overview.StoryOverviewDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
import com.shakal.rpg.api.mappers.MonsterMapper;
import com.shakal.rpg.api.mappers.StoryMapper;
import com.shakal.rpg.api.model.Monster;
import com.shakal.rpg.api.model.Story;
import com.shakal.rpg.api.repository.mongo.StoryRepository;

import com.shakal.rpg.api.dto.info.StoryInfoDTO;



import com.shakal.rpg.api.repository.StoryDAO;
import com.shakal.rpg.api.utils.Messages;
import com.shakal.rpg.api.utils.PaginationGenerator;

@Service
public class StoryService implements IStoryService {

	

	private StoryRepository storyRepository;
	
	@Autowired
	public StoryService(StoryRepository storyRepository) {
		this.storyRepository = storyRepository;
	}
	
	
	@Override
	public StoryCreateDTO insertStory(StoryCreateDTO inputDto) throws ResourceNotFoundException {

		Story entity = new Story();
		entity.setPlaces(inputDto.getPlaces().stream()
				.map(place -> StoryMapper.placeDtoToEntity(place))
				.collect(Collectors.toList()));
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
	public StoryInfoDTO getStoryById(String id) throws ResourceNotFoundException {
		Story story = this.storyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(Messages.STORY_NOT_FOUND));
		return StoryMapper.entityToInfo(story);
	}


	

}
