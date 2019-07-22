package com.shakal.rpg.api.dto.create;


import java.util.List;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.commons.NameDescriptionDTO;

public class MonsterCreateDTO {

	private String raceName;
	private String raceDescription;
	private String imagePath;
	private KeyValueDTO level;
	private List<KeyValueDTO> damageImunity;
	private List<KeyValueDTO> damageResistence;
	private List<KeyValueDTO> languages;
	private List<NameDescriptionDTO> features;
	
	
	
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
	public List<KeyValueDTO> getDamageImunity() {
		return damageImunity;
	}
	public void setDamageImunity(List<KeyValueDTO> damageImunity) {
		this.damageImunity = damageImunity;
	}
	public List<KeyValueDTO> getDamageResistence() {
		return damageResistence;
	}
	public void setDamageResistence(List<KeyValueDTO> damageResistence) {
		this.damageResistence = damageResistence;
	}
	public List<KeyValueDTO> getLanguages() {
		return languages;
	}
	public void setLanguages(List<KeyValueDTO> languages) {
		this.languages = languages;
	}
	public List<NameDescriptionDTO> getFeatures() {
		return features;
	}
	public void setFeatures(List<NameDescriptionDTO> features) {
		this.features = features;
	}
	
	
	
	
}
