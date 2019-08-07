package com.shakal.rpg.api.dto.overview;


import com.shakal.rpg.api.dto.info.LevelDTO;

public class MonsterCardDTO {

	 private long id;
	 private String name;
	 private LevelDTO level;
	 private int lifePoints;
	 private int totalLifePoints;
	 private String imagePath;
	 private int lifePercent;
	 
	 
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
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public int getTotalLifePoints() {
		return totalLifePoints;
	}
	public void setTotalLifePoints(int totalLifePoints) {
		this.totalLifePoints = totalLifePoints;
	}
	public int getLifePercent() {
		return lifePercent;
	}
	public void setLifePercent(int lifePercent) {
		this.lifePercent = lifePercent;
	}
	
	 
	 
}
