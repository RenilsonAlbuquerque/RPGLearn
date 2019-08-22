package com.shakal.rpg.api.contracts.service;

import com.shakal.rpg.api.dto.create.UserCreateDTO;
import com.shakal.rpg.api.model.character.Character;

public interface IUserService {

	long getCurrentUserId();
	void setCharacterToUserInStory(long storyId, long userId, Character character);
	UserCreateDTO insertUser(UserCreateDTO createDto);
}
