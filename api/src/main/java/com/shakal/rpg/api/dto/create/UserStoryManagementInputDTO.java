package com.shakal.rpg.api.dto.create;

import java.util.List;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;

public class UserStoryManagementInputDTO {

	private List<KeyValueDTO> allAvaliableUsers;
	private List<KeyValueDTO> usersOfStory;
	
	public List<KeyValueDTO> getAllAvaliableUsers() {
		return allAvaliableUsers;
	}
	public void setAllAvaliableUsers(List<KeyValueDTO> allAvaliableUsers) {
		this.allAvaliableUsers = allAvaliableUsers;
	}
	public List<KeyValueDTO> getUsersOfStory() {
		return usersOfStory;
	}
	public void setUsersOfStory(List<KeyValueDTO> usersOfStory) {
		this.usersOfStory = usersOfStory;
	}
	
	
}
