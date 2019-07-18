package com.shakal.rpg.api.model.enums;




public enum DiceEnum {
	
	d4(4),d6(6),d8(8),d10(10),d12(12),d20(20);
	
	private int value;
	
	private DiceEnum (int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

}
