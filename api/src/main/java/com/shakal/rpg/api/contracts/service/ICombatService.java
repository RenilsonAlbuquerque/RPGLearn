package com.shakal.rpg.api.contracts.service;

import com.shakal.rpg.api.dto.combat.CombatStateDTO;
import com.shakal.rpg.api.dto.combat.CreatureCardDTO;
import com.shakal.rpg.api.dto.info.CharacterSheetDTO;
import com.shakal.rpg.api.dto.map.MapAreaDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;

public interface ICombatService {

	
	CombatStateDTO updateCombatConditions(CombatStateDTO input, long storyId);
	CreatureCardDTO initalizePlayerTokenInStory(long storyId, CharacterSheetDTO characterSheet);
	MapAreaDTO updateMapArea(MapAreaDTO input);
	CombatStateDTO getCombatState(long storyId) throws ResourceNotFoundException;
}
