package com.shakal.rpg.api.dto.overview;

public class MonsterOverviewDTO {

	private long id;
	private String challengeLevel;
	private String race;
	private String type;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getChallengeLevel() {
		return challengeLevel;
	}
	public void setChallengeLevel(String challengeLevel) {
		this.challengeLevel = challengeLevel;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
