package com.shakal.rpg.api.model.enums;




public enum AtributeEnum {

	FORCE(0),DEXTERITY(1),CONSTITUTION(2),INTELIGENCE(3),WISDOM(4),CHARISMA(5);
	
	private int value;
	
	
	private AtributeEnum (int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
