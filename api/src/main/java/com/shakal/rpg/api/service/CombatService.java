package com.shakal.rpg.api.service;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.shakal.rpg.api.contracts.service.ICharacterService;
import com.shakal.rpg.api.contracts.service.ICombatService;
import com.shakal.rpg.api.dto.combat.CombatStateDTO;
import com.shakal.rpg.api.dto.combat.PassTurnDTO;
import com.shakal.rpg.api.dto.filter.UserSheetFIlterDTO;
import com.shakal.rpg.api.dto.combat.CreatureCardDTO;
import com.shakal.rpg.api.dto.info.CharacterGeneralInfoDTO;
import com.shakal.rpg.api.dto.info.CharacterSheetDTO;
import com.shakal.rpg.api.dto.map.MapAreaDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
import com.shakal.rpg.api.mappers.CombatStateMapper;
import com.shakal.rpg.api.model.ChallangeDificult;
import com.shakal.rpg.api.model.combatstate.CombatState;
import com.shakal.rpg.api.repository.ChallengeDificultDAO;
import com.shakal.rpg.api.repository.CombatStateDAO;
import com.shakal.rpg.api.utils.Messages;

@Service
public class CombatService implements ICombatService{
	
	private ChallengeDificultDAO challengeDificultDAO;
	private CombatStateDAO combatStateDAO;
	private ICharacterService characterService;
	private final SimpMessagingTemplate template;
	
	@Autowired
	public CombatService(ChallengeDificultDAO challengeDificultDAO,
			CombatStateDAO combatStateDao,SimpMessagingTemplate simpMessagingTemplate,
			ICharacterService characterService) {
		this.template = simpMessagingTemplate;
		this.challengeDificultDAO = challengeDificultDAO;
		this.combatStateDAO = combatStateDao;
		this.characterService = characterService;
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
					currentChallengeLevel = this.challengeDificultDAO.findById((long)creature.getLevel().getId())
							.orElse(new ChallangeDificult());
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
				.orElseThrow(() -> new ResourceNotFoundException(Messages.COMBAT_STATE_NOT_FOUND));
		return new Gson().fromJson(search.getCombatStateJSON(), CombatStateDTO.class);
	}
	
	


	@Override
	public boolean passTurn(PassTurnDTO passTurn ) throws ResourceNotFoundException {
		CombatState search = this.combatStateDAO.findById(passTurn.getStoryId())
				.orElseThrow(() -> new ResourceNotFoundException(Messages.COMBAT_STATE_NOT_FOUND));
		CombatStateDTO result = CombatStateMapper.entityToDTO(search);
		
		String nextCreature = result.getCurrentCreatureTurn();
		//Itera as criaturas
		for(short i = 0; i< result.getCreatures().size(); i++) {
			//Acha de quem é o turno atual
			if(result.getCreatures().get(i).getCombatId().equals(result.getCurrentCreatureTurn())) {
				
				short j = (short) (i+1) ;
				while(true) {
					if(j >= result.getCreatures().size()) {
						j = 0;
						continue;
					}
					if(result.getCreatures().get(j).getLifePoints() > 0) {
						nextCreature = result.getCreatures().get(j).getCombatId();
						break;
					}else {
						j++;
					}
				}
				break;
			}
		}
		result.setCurrentCreatureTurn(nextCreature);
		this.saveAndSend(passTurn.getStoryId(), result);
		return true;
	}
	

	@Override
	public boolean startCombat(long storyId) throws ResourceNotFoundException {
		CombatState search = this.combatStateDAO.findById(storyId)
				.orElseThrow(() -> new ResourceNotFoundException(Messages.COMBAT_STATE_NOT_FOUND));
		CombatStateDTO result = CombatStateMapper.entityToDTO(search);
		if(result.getCreatures().size() > 0) {
			this.rollInitiative(result);
			result.setCombatStarted(true);
			result.setCurrentCreatureTurn(result.getCreatures().get(0).getCombatId());
			this.saveAndSend(storyId, result);
		}
		return true;
	}
	@Override
	public CharacterGeneralInfoDTO enterInCombat(UserSheetFIlterDTO filter) throws ResourceNotFoundException {
		CharacterGeneralInfoDTO result = this.characterService.getCharacterSheetByUserInStory(filter);
		CombatStateDTO combatState = null;
		try {
			combatState = this.getCombatState(filter.getStoryId());
			boolean found = false;
			for(int i = 0; i < combatState.getAllyQueue().size();i++) {
				if(combatState.getAllyQueue().get(i).getPlayerId() == filter.getUserId() &&
						combatState.getAllyQueue().get(i).getId() == result.getCharacterSheet().getId()) {
					found = true;
				}
			}
			if(!found) {
				combatState.getAllyQueue().add(result.getCharacterToken());
			}
		}catch(ResourceNotFoundException e) {
			combatState = CombatStateMapper.createBlankCombatStateWithPlayer(result.getCharacterToken());
		}
		
		this.saveAndSend(filter.getStoryId(), combatState);
		return result;
	}
	
	private boolean saveAndSend(long storyId,CombatStateDTO combatState) {
		this.combatStateDAO.save(new CombatState(storyId,serializeObjectToJSON(combatState)));
		this.sendMessage(storyId, combatState);
		return true;
	}
	private void sendMessage(long id, CombatStateDTO state) {
		this.template.convertAndSend("/topic/combat/"+ id, state);
		
	}
	private void rollInitiative(CombatStateDTO combatStatus) {
		int range = (20  - 1) + 1;
		for(int i = 0; i < combatStatus.getCreatures().size(); i ++) {
			combatStatus.getCreatures().get(i).setInitiative((int) (Math.random() * range) + 1);
		}
		Collections.sort(combatStatus.getCreatures());
	}


	@Override
	public boolean resetCombat(long storyId) throws ResourceNotFoundException {
		CombatState search = this.combatStateDAO.findById(storyId)
				.orElseThrow(() -> new ResourceNotFoundException(Messages.COMBAT_STATE_NOT_FOUND));
		CombatStateDTO result = CombatStateMapper.entityToDTO(search);
		result.setCurrentCreatureTurn("");
		result.setCreatures(new ArrayList<>());
		result.setDificult(1);
		result.setEnemyQueue(new ArrayList<>());
		this.saveAndSend(storyId, result);
		return true;
	}


	

}
