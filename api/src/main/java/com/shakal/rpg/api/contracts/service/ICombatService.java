package com.shakal.rpg.api.contracts.service;

import com.shakal.rpg.api.dto.combat.CombatStateDTO;

public interface ICombatService {

	
	CombatStateDTO updateCombatConditions(CombatStateDTO input);
}
