package com.shakal.rpg.api.dto.create;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;

public class CharacterRaceAtributeBonusInput {

	private KeyValueDTO ability;
	
	private int bonus;

	public KeyValueDTO getAbility() {
		return ability;
	}

	public void setAbility(KeyValueDTO ability) {
		this.ability = ability;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	
}
