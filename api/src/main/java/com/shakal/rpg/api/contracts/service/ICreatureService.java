package com.shakal.rpg.api.contracts.service;



import com.shakal.rpg.api.dto.info.CreatureTokenDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;


public interface ICreatureService {

	CreatureTokenDTO getCreatureToken(long id) throws ResourceNotFoundException;
}
