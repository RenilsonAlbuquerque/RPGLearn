package com.shakal.rpg.api.contracts.service;

import com.shakal.rpg.api.dto.filter.CombatStateDTO;

public interface ICombatService {

	int calculateChallengeDeficult(CombatStateDTO input);
	CombatStateDTO updateMonstersConditions(CombatStateDTO input);
}
