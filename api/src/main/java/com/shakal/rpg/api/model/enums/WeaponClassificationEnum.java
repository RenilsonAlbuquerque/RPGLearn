package com.shakal.rpg.api.model.enums;

import javax.persistence.Embeddable;


public enum WeaponClassificationEnum {

	 SIMPLE("Simples"),MARTIAL("Marcial");
	
	private String value;
	
	private WeaponClassificationEnum (String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
