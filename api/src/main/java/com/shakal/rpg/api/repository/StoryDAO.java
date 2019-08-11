package com.shakal.rpg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shakal.rpg.api.model.Story;

public interface StoryDAO extends JpaRepository<Story,Long>{

}
