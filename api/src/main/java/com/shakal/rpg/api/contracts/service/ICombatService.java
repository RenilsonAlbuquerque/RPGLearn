package com.shakal.rpg.api.contracts.service;

import com.shakal.rpg.api.dto.combat.CombatStateDTO;
import com.shakal.rpg.api.dto.combat.CreatureCardDTO;
import com.shakal.rpg.api.dto.info.CharacterSheetDTO;

public interface ICombatService {

	
	CombatStateDTO updateCombatConditions(CombatStateDTO input);
	CreatureCardDTO initalizePlayerTokenInStory(long storyId, CharacterSheetDTO characterSheet);
}
