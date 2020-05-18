package com.shakal.rpg.api.model.enums;

public enum UserStoryRole {

	MASTER(1),PLAYER(2);
	
	private int value;
	
	private UserStoryRole (int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

}
