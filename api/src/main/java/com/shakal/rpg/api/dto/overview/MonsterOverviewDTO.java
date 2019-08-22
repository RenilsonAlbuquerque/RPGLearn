package com.shakal.rpg.api.dto.overview;

public class MonsterOverviewDTO {

	private long id;
	private double challengeLevel;
	private String race;
	private String type;
	private int lifePoints;
	
	
	
	public MonsterOverviewDTO() {
		super();
	}
	
	
	public MonsterOverviewDTO(long id, double challengeLevel, String race, String type, int lifePoints) {
		super();
		this.id = id;
		this.challengeLevel = challengeLevel;
		this.race = race;
		this.type = type;
		this.lifePoints = lifePoints;
	}


	public MonsterOverviewDTO(long id, double challengeLevel, String race) {
		super();
		this.id = id;
		this.challengeLevel = challengeLevel;
		this.race = race;
	}


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
	public double getChallengeLevel() {
		return challengeLevel;
	}
	public void setChallengeLevel(double challengeLevel) {
		this.challengeLevel = challengeLevel;
	}
	public int getLifePoints() {
		return lifePoints;
	}
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	
	
	
}
