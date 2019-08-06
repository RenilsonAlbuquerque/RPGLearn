package com.shakal.rpg.api.service;

import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.ICombatService;
import com.shakal.rpg.api.dto.commons.DoubleInt;
import com.shakal.rpg.api.dto.filter.CombatStateDTO;
import com.shakal.rpg.api.dto.overview.MonsterCardDTO;
import com.shakal.rpg.api.repository.ChallengeDificultDAO;

@Service
public class CombatService implements ICombatService{
	
	private ChallengeDificultDAO challengeDificultDAO;
	
	public CombatService(ChallengeDificultDAO challengeDificultDAO) {
		this.challengeDificultDAO = challengeDificultDAO;
	}

	@Override
	public String calculateChallengeDeficult(CombatStateDTO input) {
		String result = "Fácil";
		int maxLevel = 0;
		int xpSum = 0;

		for(MonsterCardDTO player: input.getPlayers()) {
			xpSum += player.getLevel().getXp();
			if(player.getLevel().getValue() > maxLevel) {
				maxLevel = player.getLevel().getValue();
			}
		}
		return result;
	}

}
