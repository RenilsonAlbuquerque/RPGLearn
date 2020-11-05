package com.shakal.rpg.api.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.shakal.rpg.api.contracts.service.ICombatService;
import com.shakal.rpg.api.dto.combat.CombatDifficultDTO;
import com.shakal.rpg.api.dto.combat.CombatStateDTO;
import com.shakal.rpg.api.dto.combat.ICreatureCardDTO;
import com.shakal.rpg.api.dto.combat.CreatureCardDTO;
import com.shakal.rpg.api.dto.info.CharacterSheetDTO;
import com.shakal.rpg.api.dto.map.MapAreaDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
import com.shakal.rpg.api.model.ChallangeDificult;
import com.shakal.rpg.api.model.combatstate.CombatState;
import com.shakal.rpg.api.repository.ChallengeDificultDAO;
import com.shakal.rpg.api.repository.CombatStateDAO;
import com.shakal.rpg.api.utils.Messages;

@Service
public class CombatService implements ICombatService{
	
	private ChallengeDificultDAO challengeDificultDAO;
	private CombatStateDAO combatStateDAO;
	private final SimpMessagingTemplate template;
	
	@Autowired
	public CombatService(ChallengeDificultDAO challengeDificultDAO,
			CombatStateDAO combatStateDao,SimpMessagingTemplate simpMessagingTemplate) {
		this.template = simpMessagingTemplate;
		this.challengeDificultDAO = challengeDificultDAO;
		this.combatStateDAO = combatStateDao;
	}

	
	private void calculateChallengeDeficult(CombatStateDTO input) {
		int result = 1;
		double maxLevel = 0;
		double xpPlayerEasySum = 0;
		double xpPlayerMediumSum = 0;
		double xpPlayerHardSum = 0;
		double xpPlayerDeadlySum = 0;
		ChallangeDificult currentChallengeLevel = null;
		
		double xpEnemySum = 0;
		double monsterMultiplierFactor = 1;
		short enemyCount = 0;
		short allyCount = 0;
		

		for(CreatureCardDTO creature: input.getCreatures()) {
			if(creature.isAlly()) {
				if(creature.getLevel().getValue() >20) {
					currentChallengeLevel = this.challengeDificultDAO.findById(20L).get();
				}else {
					currentChallengeLevel = this.challengeDificultDAO.findById((long)creature.getLevel().getId()).get();
				}
				xpPlayerEasySum += currentChallengeLevel.getEasy();
				xpPlayerMediumSum += currentChallengeLevel.getMedium();
				xpPlayerHardSum += currentChallengeLevel.getHard();
				xpPlayerDeadlySum += currentChallengeLevel.getDeadly();
				allyCount++;
			}
			else {
				xpEnemySum += creature.getLevel().getXp();
				enemyCount++;
			}
		}
		if(enemyCount > 0 && allyCount > 0) {
			if(enemyCount == 2) {
				monsterMultiplierFactor = 1.5f;
			}
			if(enemyCount >= 3 && enemyCount <= 6) {
				monsterMultiplierFactor = 2f;
			}
			if(enemyCount >= 7 && enemyCount <= 10) {
				monsterMultiplierFactor = 2.5f;
			}
			if(enemyCount >= 11 && enemyCount <= 14) {
				monsterMultiplierFactor = 3f;
			}
			if(enemyCount >= 15) {
				monsterMultiplierFactor = 4f;
			}
			xpEnemySum = xpEnemySum * monsterMultiplierFactor;
			
			
			if(xpEnemySum >= xpPlayerMediumSum) {
				result = 2;
			}
			if(xpEnemySum >= xpPlayerHardSum) {
				result = 3;
			}
			if(xpEnemySum >= xpPlayerDeadlySum) {
				result = 4;
			}
		}
		else {
			result = 1;
		}
		
		input.setDificult(result);
	}

	
	private void updateMonstersConditions(CombatStateDTO input) {

		for(CreatureCardDTO creature: input.getCreatures()) {
			creature.setLifePercent((100 * creature.getLifePoints())/ creature.getTotalLifePoints());
		}
		Collections.sort(input.getCreatures());
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
	private String serializeObjectToJSON(Object obj) {
		return new Gson().toJson(obj);
	}
	@Override
	public CombatStateDTO updateCombatConditions(CombatStateDTO input, long storyId) {
		this.updateMonstersConditions(input);
		calculateChallengeDeficult(input);
		this.combatStateDAO.save(new CombatState(storyId,serializeObjectToJSON(input)));
		this.sendMessage(storyId, input);
		return input;
	}
	

	@Override
	public CreatureCardDTO initalizePlayerTokenInStory(long storyId, CharacterSheetDTO characterSheet) {
		
		CreatureCardDTO result = new CreatureCardDTO();
		result.setId(characterSheet.getId());
		result.setName(characterSheet.getName());
		result.setImagePath(characterSheet.getImagePath());
		result.setTotalLifePoints(characterSheet.getLifePoints().getTotalLifePoints());
		return result;
	}


	@Override
	public MapAreaDTO updateMapArea(MapAreaDTO input) {
		// TODO Auto-generated method stub
		return input;
	}


	@Override
	public CombatStateDTO getCombatState(long storyId) throws ResourceNotFoundException {
		CombatState search = this.combatStateDAO.findById(storyId)
				.orElseThrow(() -> new ResourceNotFoundException(Messages.MONSTER_NOT_FOUND));
		return new Gson().fromJson(search.getCombatStateJSON(), CombatStateDTO.class);
	}
	
	private void sendMessage(long id, CombatStateDTO state) {
		this.template.convertAndSend("/topic/combat/"+ id, state);
		
	}


	@Override
	public boolean passTurn(String combatId) {
		// TODO Auto-generated method stub
		return false;
	}
}
