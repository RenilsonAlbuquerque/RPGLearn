package com.shakal.rpg.api.model.enums;

import javax.persistence.Embeddable;

@Embeddable
public enum AtributeEnum {

	FORCE(1),DEXTERITY(2),CONSTITUTION(3),INTELIGENCE(4),WISDOM(5),CHARISMA(6);
	
	private int value;
	
	private AtributeEnum (int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
