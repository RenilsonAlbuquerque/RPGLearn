package com.shakal.rpg.api.model.enums;

import javax.persistence.Embeddable;


public enum SexEnum {
	
	MALE("masculino"),
	FEMALE("Feminino"),
	OTHERS("outros");
	
	
	private String value;
	
	private SexEnum (String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
