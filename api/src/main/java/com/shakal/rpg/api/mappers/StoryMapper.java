package com.shakal.rpg.api.mappers;


import com.shakal.rpg.api.dto.overview.StoryOverviewDTO;


import java.util.stream.Collectors;

import com.shakal.rpg.api.dto.create.PlaceCreateDTO;
import com.shakal.rpg.api.dto.info.PlaceInfoDTO;
import com.shakal.rpg.api.dto.info.StoryInfoDTO;


import com.shakal.rpg.api.model.mongo.Place;
import com.shakal.rpg.api.model.mongo.Story;

public class StoryMapper {

	public static StoryOverviewDTO entityTOOverview(Story entity) {

		StoryOverviewDTO dto = new StoryOverviewDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setFolderImage(entity.getFolderImage());
		return dto;
	}

	
	public static Place placeDtoToEntity(PlaceCreateDTO inputDto) {
		Place entity = new Place();
		entity.setName(inputDto.getName());
		entity.setMap(inputDto.getMap());
		return entity;
	}
	public static PlaceInfoDTO placeEntityToDto(Place entity) {
		PlaceInfoDTO dto = new PlaceInfoDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setMap(entity.getMap());
		dto.setBackground(entity.getBackground());
		return dto;
	}
	public static StoryInfoDTO entityToInfo(Story entity) {
		StoryInfoDTO dto = new StoryInfoDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setFolderImage(entity.getFolderImage());
		dto.setBackground(entity.getBackground());
		dto.setPlaces(entity.getPlaces().stream()
					.map(place -> placeEntityToDto(place))
					.collect(Collectors.toList()));
		return dto;
	}


}
