package com.shakal.rpg.api.dto;

import java.util.List;

public class MonsterSheetDTO {
	
	private long id;
	private String name;
	private int armorClass;
	private int lifePoints;
	private List<AtributeDTO> atributes;
	private List<SavingThrowDTO> savingThrows;
	private List<String> damageResistence;
	private List<String> damageImunity;
	private List<String> languages;
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
	
	public int getArmorClass() {
		return armorClass;
	}
	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
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
	public List<String> getDamageResistence() {
		return damageResistence;
	}
	public void setDamageResistence(List<String> damageResistence) {
		this.damageResistence = damageResistence;
	}
	public List<String> getDamageImunity() {
		return damageImunity;
	}
	public void setDamageImunity(List<String> damageImunity) {
		this.damageImunity = damageImunity;
	}
	public List<String> getLanguages() {
		return languages;
	}
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
	
	
	

}
