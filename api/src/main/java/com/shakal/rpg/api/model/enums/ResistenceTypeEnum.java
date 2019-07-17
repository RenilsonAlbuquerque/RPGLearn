package com.shakal.rpg.api.model.enums;

import javax.persistence.Embeddable;


public enum ResistenceTypeEnum {

	RESISTENCE(0),
	IMUNITY(1);
	
	private int value;
	
	private ResistenceTypeEnum (int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
