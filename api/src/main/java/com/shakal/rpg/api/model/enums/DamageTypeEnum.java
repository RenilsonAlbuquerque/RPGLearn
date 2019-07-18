package com.shakal.rpg.api.model.enums;




public enum DamageTypeEnum {

	ACID(1),
	BLUDGEONING(2),
	COLD(3),
	FIRE(4),
	FORCE(5),
	LIGHTNING(6),
	NECROTIC(7),
	PIERCING(8),
	POISON(9),
	PSYCHIC(10),
	RADIANT(11),
	SLASHING(12),
	THUNDER(13);
	
	private int value;
	
	private DamageTypeEnum (int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
