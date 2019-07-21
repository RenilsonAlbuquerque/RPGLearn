package com.shakal.rpg.api.dto.create;


import com.shakal.rpg.api.dto.commons.KeyValueDTO;

public class MonsterCreateDTO {

	private String raceName;
	private String raceDescription;
	private String imagePath;
	private KeyValueDTO level;
	
	
	public String getRaceName() {
		return raceName;
	}
	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}
	public String getRaceDescription() {
		return raceDescription;
	}
	public void setRaceDescription(String raceDescription) {
		this.raceDescription = raceDescription;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public KeyValueDTO getLevel() {
		return level;
	}
	public void setLevel(KeyValueDTO level) {
		this.level = level;
	}
	
	
	
	
}
