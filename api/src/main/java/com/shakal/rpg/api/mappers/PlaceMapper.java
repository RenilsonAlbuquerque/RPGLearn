package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.overview.PlaceOverviewDTO;
import com.shakal.rpg.api.model.Place;

public class PlaceMapper {
	public static PlaceOverviewDTO entityToOverview(Place entity) {
		PlaceOverviewDTO result = new PlaceOverviewDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setFolderImage(entity.getMap());
		return result;
	}
}
