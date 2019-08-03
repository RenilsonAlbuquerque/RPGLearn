package com.shakal.rpg.api.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.shakal.rpg.api.model.Story;

public interface StoryRepository extends MongoRepository<Story, String> {

}
