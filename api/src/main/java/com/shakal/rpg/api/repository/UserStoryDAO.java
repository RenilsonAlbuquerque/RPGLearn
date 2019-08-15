package com.shakal.rpg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shakal.rpg.api.model.embedded.UserStoryId;
import com.shakal.rpg.api.model.relation.UserStory;

public interface UserStoryDAO  extends JpaRepository<UserStory,UserStoryId>{

}
