package com.shakal.rpg.api.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.ICombatService;
import com.shakal.rpg.api.dto.filter.CombatStateDTO;
import com.shakal.rpg.api.dto.overview.MonsterCardDTO;
import com.shakal.rpg.api.model.ChallangeDificult;
import com.shakal.rpg.api.repository.ChallengeDificultDAO;

@Service
public class CombatService implements ICombatService{
	
	private ChallengeDificultDAO challengeDificultDAO;
	
	@Autowired
	public CombatService(ChallengeDificultDAO challengeDificultDAO) {
		this.challengeDificultDAO = challengeDificultDAO;
	}

	
	private int calculateChallengeDeficult(CombatStateDTO input) {
		int result = 1;
		double maxLevel = 0;
		double xpPlayersSum = 0;
		double xpMonsterSum = 0;
		int monsterMultiplierFactor = 1;

		for(MonsterCardDTO player: input.getPlayers()) {
			xpPlayersSum += player.getLevel().getXp();
			if(player.getLevel().getValue() > maxLevel) {
				maxLevel = player.getLevel().getValue();
			}
		}
		for(MonsterCardDTO monster: input.getMonsters()) {
			xpMonsterSum += monster.getLevel().getXp();
		}
		xpMonsterSum = xpMonsterSum * this.multiplierFactor(input.getMonsters().size());
		
		ChallangeDificult currentChallenge = this.challengeDificultDAO.getOne(1L);
		if(xpPlayersSum > currentChallenge.getEasy()) {
			if(xpPlayersSum < currentChallenge.getMedium()) {
				
			}
		}
		
		return result;
	}

	
	private CombatStateDTO updateMonstersConditions(CombatStateDTO input) {
		for(MonsterCardDTO monster: input.getMonsters()) {
			monster.setLifePercent((100 * monster.getLifePoints())/ monster.getTotalLifePoints() );
		}
		Collections.sort(input.getMonsters());
		for(MonsterCardDTO player: input.getPlayers()) {
			player.setLifePercent((100 * player.getLifePoints())/ player.getTotalLifePoints() );
		}
		Collections.sort(input.getPlayers());
		return input;
	}

	private double multiplierFactor(int monsterQuantity) {
		double result = 1;
		if(monsterQuantity == 2 ) {
			result = 1.5;
		}
		if(monsterQuantity >= 3 && monsterQuantity <= 6) {
			result = 2;
		}
		if(monsterQuantity >= 7 && monsterQuantity <= 10) {
			result = 2.5;
		}
		if(monsterQuantity >= 15) {
			result = 4;
		}
		return result;
	}
	@Override
	public CombatStateDTO updateCombatConditions(CombatStateDTO input) {
		input = this.updateMonstersConditions(input);
		return input;
	}
}
