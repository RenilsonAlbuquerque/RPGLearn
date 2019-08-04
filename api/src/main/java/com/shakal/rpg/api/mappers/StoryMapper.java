package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.overview.StoryOverviewDTO;
import com.shakal.rpg.api.model.History;

public class StoryMapper {

	public static StoryOverviewDTO entityTOOverview(History entity) {
		StoryOverviewDTO dto = new StoryOverviewDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setFolderImage(entity.getFolderImage());
		return dto;
	}

}
