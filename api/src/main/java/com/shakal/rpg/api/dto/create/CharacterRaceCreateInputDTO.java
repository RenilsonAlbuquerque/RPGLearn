package com.shakal.rpg.api.dto.create;

import java.util.List;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;

public class CharacterRaceCreateInputDTO {

	private String description;
	private int speed;
	private String alignmentDescription;
	private List<CharacterRaceAtributeBonusInput> atributeBonus;
	private String ageDescription;
	private String sizeDescription;
	private List<KeyValueDTO> languages;
	
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getAlignmentDescription() {
		return alignmentDescription;
	}
	public void setAlignmentDescription(String alignmentDescription) {
		this.alignmentDescription = alignmentDescription;
	}
	public List<CharacterRaceAtributeBonusInput> getAtributeBonus() {
		return atributeBonus;
	}
	public void setAtributeBonus(List<CharacterRaceAtributeBonusInput> atributeBonus) {
		this.atributeBonus = atributeBonus;
	}
	public String getAgeDescription() {
		return ageDescription;
	}
	public void setAgeDescription(String ageDescription) {
		this.ageDescription = ageDescription;
	}
	public String getSizeDescription() {
		return sizeDescription;
	}
	public void setSizeDescription(String sizeDescription) {
		this.sizeDescription = sizeDescription;
	}
	public List<KeyValueDTO> getLanguages() {
		return languages;
	}
	public void setLanguages(List<KeyValueDTO> languages) {
		this.languages = languages;
	}
	
	
	
	
}
