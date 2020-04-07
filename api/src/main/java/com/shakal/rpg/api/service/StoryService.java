package com.shakal.rpg.api.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.IStoryService;
import com.shakal.rpg.api.contracts.service.IUserService;
import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.create.PlaceCreateDTO;
import com.shakal.rpg.api.dto.create.StoryCreateDTO;
import com.shakal.rpg.api.dto.create.StoryCreateInputDTO;
import com.shakal.rpg.api.dto.filter.CustomPage;
import com.shakal.rpg.api.dto.filter.PaginationFilter;
import com.shakal.rpg.api.dto.info.StoryInfoDTO;
import com.shakal.rpg.api.dto.overview.MonsterOverviewDTO;
import com.shakal.rpg.api.dto.overview.StoryOverviewDTO;
import com.shakal.rpg.api.exception.BusinessException;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
import com.shakal.rpg.api.mappers.MonsterMapper;
import com.shakal.rpg.api.mappers.StoryMapper;
import com.shakal.rpg.api.mappers.UserMapper;
import com.shakal.rpg.api.model.Monster;
import com.shakal.rpg.api.model.Place;
import com.shakal.rpg.api.model.Story;
import com.shakal.rpg.api.model.User;
import com.shakal.rpg.api.model.embedded.UserStoryId;
import com.shakal.rpg.api.model.enums.UserStoryRole;
import com.shakal.rpg.api.model.relation.UserStory;
import com.shakal.rpg.api.repository.PlaceDAO;
import com.shakal.rpg.api.repository.StoryDAO;
import com.shakal.rpg.api.repository.UserDAO;
import com.shakal.rpg.api.repository.UserStoryDAO;
import com.shakal.rpg.api.specification.MonsterSpecification;
import com.shakal.rpg.api.specification.StorySpecification;
import com.shakal.rpg.api.utils.Messages;
import com.shakal.rpg.api.utils.PaginationGenerator;
import com.shakal.rpg.api.validators.ErrorMessages;
import com.shakal.rpg.api.validators.StoryValidator;

@Service
public class StoryService implements IStoryService {

	
	private StoryDAO storyRepository;
	private PlaceDAO placeRepository;
	private UserDAO userDao;
	private IUserService userService;
	private UserStoryDAO userStoryDao;
	
	@Autowired
	public StoryService(StoryDAO storyRepository, UserDAO userDao,
			UserStoryDAO userStoryDao,PlaceDAO placeDAO,IUserService userService) {
		this.storyRepository = storyRepository;
		this.userDao = userDao;
		this.userStoryDao = userStoryDao;
		this.placeRepository = placeDAO;
		this.userService = userService;
	}
	
	@Override
	public StoryCreateDTO insertStory(StoryCreateDTO inputDto) throws ResourceNotFoundException,BusinessException {
		ErrorMessages error = new ErrorMessages();
		StoryValidator.ValidateDTO(inputDto, error);
		if(error.hasError()) {
			throw new BusinessException(error.getMessages().toString());
		}
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
		this.setUsersInStory(entity, inputDto.getUsers(), this.userService.getCurrentUserId());
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
	private void setUsersInStory(Story story, List<KeyValueDTO> users, long masterId) {
		for(KeyValueDTO user: users) {
			User userEntity = this.userDao.getOne(user.getId());
			UserStory userStory = new UserStory();
			userStory.setId(new UserStoryId(user.getId(),story.getId()));
			userStory.setStory(story);
			userStory.setUser(userEntity);
			this.userStoryDao.save(userStory);
		}
		User masterEntity = this.userDao.getOne(masterId);
		UserStory masterStory = new UserStory();
		masterStory.setId(new UserStoryId(masterEntity.getId(),story.getId()));
		masterStory.setStory(story);
		masterStory.setUser(masterEntity);
		masterStory.setMaster(true);
		this.userStoryDao.save(masterStory);
		
	}

	@Override
	public CustomPage<StoryOverviewDTO> listsStoriesByUserIdPaged(PaginationFilter filter, long userId) {
		Page<StoryOverviewDTO> page = this.userStoryDao.retrieveStoriesAsDTO(PageRequest.of(filter.getPage() -1, 
				filter.getSize()), userId);
		CustomPage<StoryOverviewDTO> storyOverview =  (CustomPage<StoryOverviewDTO>) PaginationGenerator.convertPage(page);
		
		storyOverview.getElements().forEach( story -> {
			story.setUserRoleInStory(this.getUserRoleInStory(story.getId(), userId));
		});
		
		return storyOverview;
	}
	private void setPlaces(Story story,List<PlaceCreateDTO> placeInput) {
		for(PlaceCreateDTO placeDto: placeInput) {
			Place entity = StoryMapper.placeDtoToEntity(placeDto);
			entity.setStory(story);
			this.placeRepository.save(entity);
		} 
	}

	@Override
	public UserStoryRole checkUserRole(long storyId,long userId) throws ResourceNotFoundException {
		UserStoryRole result = UserStoryRole.PLAYER;
		List<UserStory> userStories = this.userStoryDao.retrieveRoleOfUserInStory(storyId)
		.orElseThrow(() -> new ResourceNotFoundException(Messages.STORY_NOT_FOUND));
		for(UserStory userStory: userStories) {
			if(userStory.getUser().getId() == userId && userStory.isMaster()) {
				result = UserStoryRole.MASTER;
			}
		}
		return result;
	
	}
	private int getUserRoleInStory(long storyId,long userId) {
		int result = UserStoryRole.PLAYER.getValue();
		List<UserStory> userStories = this.userStoryDao.retrieveRoleOfUserInStory(storyId).get();
		for(UserStory userStory: userStories) {
			if(userStory.getUser().getId() == userId && userStory.isMaster()) {
				result = UserStoryRole.MASTER.getValue();
			}
		}
		return result;
	}

	@Override
	public CustomPage<StoryOverviewDTO> searchUserStoriesPaged(long userId,String name, PaginationFilter filter) {
		Specification<Story> specification = StorySpecification.searchStory(name);
		Page<Story> page = this.storyRepository.findAll(specification,PageRequest.of(filter.getPage() -1, 
				filter.getSize()));
		CustomPage<StoryOverviewDTO> storyOverview =  (CustomPage<StoryOverviewDTO>) PaginationGenerator.convertPage(page);
		//storyOverview.getElements().removeIf(value -> value.getId() != userId);
		/*
		storyOverview.getElements().forEach( story -> {
			story.setUserRoleInStory(this.getUserRoleInStory(story.getId(), userId));
		});*/
		/*TO DO - */
		return storyOverview;
	}

}
