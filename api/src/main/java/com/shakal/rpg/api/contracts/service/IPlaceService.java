package com.shakal.rpg.api.contracts.service;

import com.shakal.rpg.api.dto.info.PlaceInfoDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;

public interface IPlaceService {

	PlaceInfoDTO getStoryById(long id) throws ResourceNotFoundException;
}
