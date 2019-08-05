package com.shakal.rpg.api.service;

import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.ICombatService;
import com.shakal.rpg.api.dto.commons.DoubleInt;
import com.shakal.rpg.api.dto.filter.ChallengeDificultInputDTO;
import com.shakal.rpg.api.repository.ChallengeDificultDAO;

@Service
public class CombatService implements ICombatService{
	
	private ChallengeDificultDAO challengeDificultDAO;
	
	public CombatService(ChallengeDificultDAO challengeDificultDAO) {
		this.challengeDificultDAO = challengeDificultDAO;
	}

	@Override
	public String calculateChallengeDeficult(ChallengeDificultInputDTO input) {
		String result = "Fácil";
		int maxLevel = 0;
		int xpSum = 0;
		for(DoubleInt player: input.getPlayers()) {
			xpSum += player.getXp();
			if(player.getLevel() > maxLevel) {
				maxLevel = player.getLevel();
			}
		}
		return result;
	}

}
