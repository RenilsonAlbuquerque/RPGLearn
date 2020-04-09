package com.shakal.rpg.api.dto.combat;

import com.shakal.rpg.api.dto.info.LevelDTO;


public class PlayerCardDTO implements Comparable<PlayerCardDTO>{
	
	 private long id;
	 private String name;
	 private LevelDTO level;
	 private int lifePoints;
	 private int totalLifePoints;
	 private String imagePath;
	 private int lifePercent;
	 private int speed;
	 private CardPositionDTO position;
	 private int playerId;
	 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	@Override
	public int compareTo(PlayerCardDTO o) {
		// TODO Auto-generated method stub
		return (this.getLifePercent() > o.getLifePercent()) ? 1: -1;
	}
	 
	 
}