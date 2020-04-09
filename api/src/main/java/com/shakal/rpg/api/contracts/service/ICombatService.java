package com.shakal.rpg.api.contracts.service;

import com.shakal.rpg.api.dto.combat.CombatStateDTO;
import com.shakal.rpg.api.dto.combat.PlayerCardDTO;
import com.shakal.rpg.api.dto.info.CharacterSheetDTO;

public interface ICombatService {

	
	CombatStateDTO updateCombatConditions(CombatStateDTO input);
	PlayerCardDTO initalizePlayerTokenInStory(long storyId, CharacterSheetDTO characterSheet);
}
