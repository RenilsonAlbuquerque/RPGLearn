package com.shakal.rpg.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shakal.rpg.api.dto.overview.StoryOverviewDTO;
import com.shakal.rpg.api.model.embedded.UserStoryId;
import com.shakal.rpg.api.model.relation.UserStory;

public interface UserStoryDAO  extends JpaRepository<UserStory,UserStoryId>{

	@Query("SELECT new com.shakal.rpg.api.dto.overview.StoryOverviewDTO(us.story.id, us.story.name"
	  		+ ",us.story.folderImage) FROM UserStory us FETCH ALL PROPERTIES")
	  Page<StoryOverviewDTO> retrieveStoriesAsDTO(Pageable pageable);
}
