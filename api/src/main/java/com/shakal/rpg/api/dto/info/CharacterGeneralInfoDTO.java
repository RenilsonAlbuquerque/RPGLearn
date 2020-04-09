package com.shakal.rpg.api.dto.info;

import com.shakal.rpg.api.dto.combat.PlayerCardDTO;

public class CharacterGeneralInfoDTO {
	
	private CharacterSheetDTO characterSheet;
	private PlayerCardDTO characterToken;
	
	public CharacterSheetDTO getCharacterSheet() {
		return characterSheet;
	}
	public void setCharacterSheet(CharacterSheetDTO characterSheet) {
		this.characterSheet = characterSheet;
	}
	public PlayerCardDTO getCharacterToken() {
		return characterToken;
	}
	public void setCharacterToken(PlayerCardDTO characterToken) {
		this.characterToken = characterToken;
	}
	
	

}
