package com.shakal.rpg.api.dto.info;

import com.shakal.rpg.api.dto.combat.CreatureCardDTO;

public class CharacterGeneralInfoDTO {
	
	private CharacterSheetDTO characterSheet;
	private CreatureCardDTO characterToken;
	
	public CharacterSheetDTO getCharacterSheet() {
		return characterSheet;
	}
	public void setCharacterSheet(CharacterSheetDTO characterSheet) {
		this.characterSheet = characterSheet;
	}
	public CreatureCardDTO getCharacterToken() {
		return characterToken;
	}
	public void setCharacterToken(CreatureCardDTO characterToken) {
		this.characterToken = characterToken;
	}
	
	

}
