package com.shakal.rpg.api.model.enums;

import javax.persistence.Embeddable;


public enum NatureEnum {

	
	GOOD("Bom"),
	NEUTRAL("Neutro"),
	EVIL("Mau");
	
	
	private String value;
	
	private NatureEnum (String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
