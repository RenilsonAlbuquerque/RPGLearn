package com.shakal.rpg.api.contracts.service;

import com.shakal.rpg.api.dto.combat.CombatStateDTO;
import com.shakal.rpg.api.dto.combat.CreatureCardDTO;
import com.shakal.rpg.api.dto.combat.PassTurnDTO;
import com.shakal.rpg.api.dto.filter.UserSheetFIlterDTO;
import com.shakal.rpg.api.dto.info.CharacterGeneralInfoDTO;
import com.shakal.rpg.api.dto.info.CharacterSheetDTO;
import com.shakal.rpg.api.dto.map.MapAreaDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;

public interface ICombatService {

	
	CombatStateDTO updateCombatConditions(CombatStateDTO input, long storyId);
	CreatureCardDTO initalizePlayerTokenInStory(long storyId, CharacterSheetDTO characterSheet);
	MapAreaDTO updateMapArea(MapAreaDTO input);
	boolean passTurn(PassTurnDTO passTurnDto) throws ResourceNotFoundException;
	boolean startCombat(long storyId) throws ResourceNotFoundException;
	boolean resetCombat(long storyId) throws ResourceNotFoundException;
	CombatStateDTO getCombatState(long storyId) throws ResourceNotFoundException;
	CharacterGeneralInfoDTO enterInCombat(UserSheetFIlterDTO filter) throws ResourceNotFoundException;
	
}
