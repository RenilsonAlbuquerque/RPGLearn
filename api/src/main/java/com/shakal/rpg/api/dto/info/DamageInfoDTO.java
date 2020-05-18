package com.shakal.rpg.api.dto.info;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;

public class DamageInfoDTO {
	
	private int bonus;
	private int quantity;
	private KeyValueDTO dice;
	private KeyValueDTO damageType;
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public KeyValueDTO getDice() {
		return dice;
	}
	public void setDice(KeyValueDTO dice) {
		this.dice = dice;
	}
	public KeyValueDTO getDamageType() {
		return damageType;
	}
	public void setDamageType(KeyValueDTO damageType) {
		this.damageType = damageType;
	}
	
	
	

}
