package com.shakal.rpg.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shakal.rpg.api.dto.overview.StoryOverviewDTO;
import com.shakal.rpg.api.model.embedded.UserStoryId;
import com.shakal.rpg.api.model.relation.UserStory;


public interface UserStoryDAO  extends JpaRepository<UserStory,UserStoryId>{

	@Query("SELECT new com.shakal.rpg.api.dto.overview.StoryOverviewDTO(us.story.id, us.story.name"
	  		+ ",us.story.folderImage) FROM UserStory us FETCH ALL PROPERTIES "
	  		+ "where us.user.id = ?1")
	  Page<StoryOverviewDTO> retrieveStoriesAsDTO(Pageable pageable,long userId);
	
	@Query("SELECT us FROM UserStory us FETCH ALL PROPERTIES where us.user.id = ?1 and us.story.id = ?2 ")
	Optional<UserStory> retrieveCharacterOfUserInStory(long userId, long storyId);
	
	@Query("SELECT us FROM UserStory us FETCH ALL PROPERTIES where us.story.id = ?1")
	Optional<List<UserStory>> retrieveRoleOfUserInStory(long storyId);
	
	@Query("SELECT us FROM UserStory us FETCH ALL PROPERTIES where us.story.id = ?1")
	List<UserStory> retrieveAllUsersInStory(long storyId);
	
}
