package com.shakal.rpg.api.contracts.service;

import com.shakal.rpg.api.dto.create.ClassDetailInputDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;

public interface IClassService {
	ClassDetailInputDTO getClassMetadata(Long raceId) throws ResourceNotFoundException;

}
