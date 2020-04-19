package com.shakal.rpg.api.dto.combat;

import java.io.Serializable;

public enum CombatDifficultDTO implements Serializable {

	easy(1),
    normal(2),
    hard(3),
    deadly(4);
    
    private int value;
	
	private CombatDifficultDTO(int value){
		this.value = value;
	}
	private CombatDifficultDTO(){
		this.value = 1;
	}
	
	public int getValue() {
		return value;
	}
}
