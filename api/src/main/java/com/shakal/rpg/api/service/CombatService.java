package com.shakal.rpg.api.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.ICombatService;
import com.shakal.rpg.api.dto.combat.CombatStateDTO;
import com.shakal.rpg.api.dto.combat.ICreatureCardDTO;
import com.shakal.rpg.api.dto.combat.CreatureCardDTO;
import com.shakal.rpg.api.dto.info.CharacterSheetDTO;
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

		for(CreatureCardDTO creature: input.getCreatures()) {
			if(creature.isAlly()) {
				xpPlayersSum += creature.getLevel().getXp();
				if(creature.getLevel().getValue() > maxLevel) {
					maxLevel = creature.getLevel().getValue();
				}
			}
			else {
				xpMonsterSum += creature.getLevel().getXp();
			}
			
		}
		
		ChallangeDificult currentChallenge = this.challengeDificultDAO.getOne(1L);
		if(xpPlayersSum > currentChallenge.getEasy()) {
			if(xpPlayersSum < currentChallenge.getMedium()) {
				
			}
		}
		
		return result;
	}

	
	private CombatStateDTO updateMonstersConditions(CombatStateDTO input) {

		for(CreatureCardDTO creature: input.getCreatures()) {
			creature.setLifePercent((100 * creature.getLifePoints())/ creature.getTotalLifePoints());
		}
		Collections.sort(input.getCreatures());
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


	@Override
	public CreatureCardDTO initalizePlayerTokenInStory(long storyId, CharacterSheetDTO characterSheet) {
		
		CreatureCardDTO result = new CreatureCardDTO();
		result.setId(characterSheet.getId());
		result.setName(characterSheet.getName());
		result.setImagePath(characterSheet.getImagePath());
		result.setTotalLifePoints(characterSheet.getTotalLifePoints());
		return result;
	}
	
}
