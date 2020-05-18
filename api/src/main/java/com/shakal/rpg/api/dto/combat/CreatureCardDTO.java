package com.shakal.rpg.api.dto.combat;

import com.shakal.rpg.api.dto.info.LevelDTO;


public class CreatureCardDTO implements Comparable<CreatureCardDTO>{
	
	 private long id;
	 private String combatId;
	 private String name;
	 private LevelDTO level;
	 private int lifePoints;
	 private int totalLifePoints;
	 private String imagePath;
	 private int lifePercent;
	 private CardPositionDTO position;
	 private long playerId;
	 private int speed;
	 private double size;
	 private boolean ally;
	 private int initiative;

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCombatId() {
		return combatId;
	}


	public void setCombatId(String combatId) {
		this.combatId = combatId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LevelDTO getLevel() {
		return level;
	}


	public void setLevel(LevelDTO level) {
		this.level = level;
	}


	public int getLifePoints() {
		return lifePoints;
	}


	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}


	public int getTotalLifePoints() {
		return totalLifePoints;
	}


	public void setTotalLifePoints(int totalLifePoints) {
		this.totalLifePoints = totalLifePoints;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public int getLifePercent() {
		return lifePercent;
	}


	public void setLifePercent(int lifePercent) {
		this.lifePercent = lifePercent;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public CardPositionDTO getPosition() {
		return position;
	}


	public void setPosition(CardPositionDTO position) {
		this.position = position;
	}


	public long getPlayerId() {
		return playerId;
	}


	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}


	public double getSize() {
		return size;
	}


	public void setSize(double size) {
		this.size = size;
	}


	public boolean isAlly() {
		return ally;
	}


	public void setAlly(boolean ally) {
		this.ally = ally;
	}


	public int getInitiative() {
		return initiative;
	}


	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}


	@Override
	public int compareTo(CreatureCardDTO o) {
		// TODO Auto-generated method stub
		return (this.getInitiative() < o.getInitiative()) ? 1: -1;
	}
	 
	 
}