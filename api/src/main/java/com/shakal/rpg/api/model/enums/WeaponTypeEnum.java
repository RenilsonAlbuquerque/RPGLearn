package com.shakal.rpg.api.model.enums;

public enum WeaponTypeEnum {
	SYMPLE(1),MARTIAL(2);
	
	private int value;
	
	private WeaponTypeEnum (int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

}
