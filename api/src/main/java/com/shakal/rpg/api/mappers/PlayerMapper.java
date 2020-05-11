package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.model.User;

public class PlayerMapper {
	
	public static KeyValueDTO mapEntityToOverview(User user) {
		KeyValueDTO result = new KeyValueDTO();
		result.setId(user.getId());
		result.setValue(user.getUsername());
		return result;
	}

}
