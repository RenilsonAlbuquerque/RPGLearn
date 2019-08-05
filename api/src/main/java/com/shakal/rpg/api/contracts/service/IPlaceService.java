package com.shakal.rpg.api.contracts.service;

import com.shakal.rpg.api.dto.create.PlaceCreateDTO;
import com.shakal.rpg.api.dto.info.PlaceInfoDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
import com.shakal.rpg.api.model.mongo.Place;

public interface IPlaceService {

	PlaceInfoDTO getStoryById(String id) throws ResourceNotFoundException;
	Place savePlace(PlaceCreateDTO inputDto);
}
