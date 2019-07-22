package com.shakal.rpg.api.dto.create;


import java.util.List;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.commons.NameDescriptionDTO;

public class MonsterCreateDTO {

	private String raceName;
	private String raceDescription;
	private String imagePath;
	private long size;
	private long type;
	private long alignment;
	private int armorClass;
	private int lifePoints;
	private int force;
	private int dexterity;
	private int constitution;
	private int inteligence;
	private int wisdom;
	private int charisma;
	private long level;
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
	
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public long getType() {
		return type;
	}
	public void setType(long type) {
		this.type = type;
	}
	public long getAlignment() {
		return alignment;
	}
	public void setAlignment(long alignment) {
		this.alignment = alignment;
	}
	
	public long getLevel() {
		return level;
	}
	public void setLevel(long level) {
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
	public int getForce() {
		return force;
	}
	public void setForce(int force) {
		this.force = force;
	}
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	public int getConstitution() {
		return constitution;
	}
	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}
	public int getInteligence() {
		return inteligence;
	}
	public void setInteligence(int inteligence) {
		this.inteligence = inteligence;
	}
	public int getWisdom() {
		return wisdom;
	}
	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}
	public int getCharisma() {
		return charisma;
	}
	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}
	
	
	
	
}
