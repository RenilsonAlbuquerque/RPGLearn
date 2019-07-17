package com.shakal.rpg.api.dto;

import java.util.List;

public class MonsterSheetDTO {
	
	private long id;
	private String name;
	private int lifePoints;
	private List<AtributeDTO> atributes;
	private List<SavingThrowDTO> savingThrows;
	private List<NameDescriptionDTO> features;
	
	
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
	public int getLifePoints() {
		return lifePoints;
	}
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	public List<AtributeDTO> getAtributes() {
		return atributes;
	}
	public void setAtributes(List<AtributeDTO> atributes) {
		this.atributes = atributes;
	}
	public List<NameDescriptionDTO> getFeatures() {
		return features;
	}
	public void setFeatures(List<NameDescriptionDTO> features) {
		this.features = features;
	}
	public List<SavingThrowDTO> getSavingThrows() {
		return savingThrows;
	}
	public void setSavingThrows(List<SavingThrowDTO> savingThrows) {
		this.savingThrows = savingThrows;
	}
	
	
	

}
