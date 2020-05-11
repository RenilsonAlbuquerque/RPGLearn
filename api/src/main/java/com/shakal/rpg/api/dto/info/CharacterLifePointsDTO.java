package com.shakal.rpg.api.dto.info;

public class CharacterLifePointsDTO {
	
	private int totalLifePoints;
	private int currentLifePoints;
	private String hitDice;
	public int getTotalLifePoints() {
		return totalLifePoints;
	}
	public void setTotalLifePoints(int totalLifePoints) {
		this.totalLifePoints = totalLifePoints;
	}
	public int getCurrentLifePoints() {
		return currentLifePoints;
	}
	public void setCurrentLifePoints(int currentLifePoints) {
		this.currentLifePoints = currentLifePoints;
	}
	public String getHitDice() {
		return hitDice;
	}
	public void setHitDice(String hitDice) {
		this.hitDice = hitDice;
	}
	
	

}
