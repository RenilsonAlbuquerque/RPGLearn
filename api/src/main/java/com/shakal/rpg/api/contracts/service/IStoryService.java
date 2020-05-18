package com.shakal.rpg.api.contracts.service;

import com.shakal.rpg.api.dto.create.StoryCreateDTO;
import com.shakal.rpg.api.dto.create.StoryCreateInputDTO;
import com.shakal.rpg.api.dto.filter.CustomPage;
import com.shakal.rpg.api.dto.filter.PaginationFilter;
import com.shakal.rpg.api.dto.info.StoryInfoDTO;
import com.shakal.rpg.api.dto.overview.StoryOverviewDTO;
import com.shakal.rpg.api.exception.BusinessException;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
import com.shakal.rpg.api.model.enums.UserStoryRole;

public interface IStoryService  {
	
	StoryCreateDTO insertStory(StoryCreateDTO inputDto) throws ResourceNotFoundException, BusinessException;
	CustomPage<StoryOverviewDTO> listsStoriesPaged(PaginationFilter filter);
	CustomPage<StoryOverviewDTO> listsStoriesByUserIdPaged(PaginationFilter filter,long userId);
	StoryInfoDTO getStoryById(long id) throws ResourceNotFoundException;
	StoryCreateInputDTO getStoryInfoToCreate();
	UserStoryRole checkUserRole(long storyId,long userId) throws ResourceNotFoundException;
	CustomPage<StoryOverviewDTO> searchUserStoriesPaged(long userId,String name, PaginationFilter filter);

}
