package com.shakal.rpg.api.dto.create;

import java.util.List;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;

public class StoryCreateInputDTO {
	private List<KeyValueDTO> users;

	public List<KeyValueDTO> getUsers() {
		return users;
	}

	public void setUsers(List<KeyValueDTO> users) {
		this.users = users;
	}

	
}
