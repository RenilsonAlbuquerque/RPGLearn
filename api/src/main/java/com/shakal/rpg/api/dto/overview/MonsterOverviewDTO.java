package com.shakal.rpg.api.dto.overview;

public class MonsterOverviewDTO {

	private long id;
	private int challengeLevel;
	private String race;
	private String type;
	private int lifePoints;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public int getChallengeLevel() {
		return challengeLevel;
	}
	public void setChallengeLevel(int challengeLevel) {
		this.challengeLevel = challengeLevel;
	}
	public int getLifePoints() {
		return lifePoints;
	}
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	
	
	
}
