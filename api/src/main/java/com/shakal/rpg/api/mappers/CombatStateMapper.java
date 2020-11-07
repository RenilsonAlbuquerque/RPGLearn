package com.shakal.rpg.api.mappers;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.shakal.rpg.api.dto.combat.CombatStateDTO;
import com.shakal.rpg.api.dto.combat.CreatureCardDTO;
import com.shakal.rpg.api.model.combatstate.CombatState;

public abstract class CombatStateMapper {
	
	public static CombatStateDTO entityToDTO(CombatState entity) {
		return new Gson().fromJson(entity.getCombatStateJSON(), CombatStateDTO.class);
	}
	public static CombatStateDTO createBlankCombatStateWithPlayer(CreatureCardDTO playerToken) {
		CombatStateDTO combatState = new CombatStateDTO();
		List<CreatureCardDTO> allyQueue = new ArrayList<CreatureCardDTO>();
		List<CreatureCardDTO> enemy = new ArrayList<CreatureCardDTO>();
		List<CreatureCardDTO> creatures = new ArrayList<CreatureCardDTO>();
		allyQueue.add(playerToken);
		combatState.setAllyQueue(allyQueue);
		combatState.setEnemyQueue(enemy);
		combatState.setCreatures(creatures);
		combatState.setCurrentCreatureTurn("");
		return combatState;
		
	}
}
