package com.shakal.rpg.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.IRaceService;
import com.shakal.rpg.api.dto.create.CharacterRaceCreateInputDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
import com.shakal.rpg.api.mappers.RaceMapper;
import com.shakal.rpg.api.model.Race;
import com.shakal.rpg.api.model.race.SubRace;
import com.shakal.rpg.api.repository.RaceDAO;
import com.shakal.rpg.api.repository.SubRaceDAO;
import com.shakal.rpg.api.utils.Messages;

@Service
public class RaceService implements IRaceService{

	private RaceDAO raceDAO;
	private SubRaceDAO subRaceDAO;
	
	@Autowired
	public RaceService(RaceDAO raceDAO,SubRaceDAO subRaceDAO) {
		this.raceDAO = raceDAO;
		this.subRaceDAO = subRaceDAO;
	}

	@Override
	public CharacterRaceCreateInputDTO getCharacterRaceMetadata(Long raceId) throws ResourceNotFoundException {
		Race search = this.raceDAO.findById(raceId)
				.orElseThrow(() -> new ResourceNotFoundException(Messages.STORY_NOT_FOUND));
		return RaceMapper.mapRaceEntityToDetail(search);
	}

	@Override
	public CharacterRaceCreateInputDTO getCharacterSubRaceMetadata(Long raceId) throws ResourceNotFoundException {
		SubRace search = this.subRaceDAO.findById(raceId)
				.orElseThrow(() -> new ResourceNotFoundException(Messages.STORY_NOT_FOUND));
		return RaceMapper.mapSubRaceEntityToMetadataDTO(search);
	}
}
