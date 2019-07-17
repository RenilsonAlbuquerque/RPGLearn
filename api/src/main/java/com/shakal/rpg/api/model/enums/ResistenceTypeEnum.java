package com.shakal.rpg.api.model.enums;

import javax.persistence.Embeddable;


public enum ResistenceTypeEnum {

	RESISTENCE(1),
	IMUNITY(2);
	
	private int value;
	
	private ResistenceTypeEnum (int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
