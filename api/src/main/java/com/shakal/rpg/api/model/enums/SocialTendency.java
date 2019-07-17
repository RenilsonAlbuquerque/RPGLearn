package com.shakal.rpg.api.model.enums;

import javax.persistence.Embeddable;


public enum SocialTendency {
	
	CHAOTIC("Caótico"),
	LAWFULL("Leal"),
	NEUTRAL("Neutro");
	
	
	private String value;
	
	private SocialTendency(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
