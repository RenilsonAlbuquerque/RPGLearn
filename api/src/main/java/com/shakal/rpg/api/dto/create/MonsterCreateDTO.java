package com.shakal.rpg.api.dto.create;


import java.util.List;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.commons.NameDescriptionDTO;

public class MonsterCreateDTO {

	private String raceName;
	private String raceDescription;
	private String imagePath;
	private String tokenImageRaw;
	private long alignment;
	private long size;
	private long type;
	private int armorClass;
	private int lifePoints;
	private int speed;
	private int force;
	private boolean proeficientForce;
	private int dexterity;
	private boolean proeficientDexterity;
	private int constitution;
	private boolean proeficientConstitution;
	private int inteligence;
	private boolean proeficientInteligence;
	private int wisdom;
	private boolean proeficientWisdom;
	private int charisma;
	private boolean proeficientCharisma;
	private long level;
	private List<KeyValueDTO> damageImunity;
	private List<KeyValueDTO> damageResistence;
	private List<KeyValueDTO> languages;
	private List<NameDescriptionDTO> features;
	private List<ActionCreateDTO> actions;
	private List<ActionCreateDTO> legendaryActions;
	
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
	
	public String getTokenImageRaw() {
		return tokenImageRaw;
	}
	public void setTokenImageRaw(String tokenImageRaw) {
		this.tokenImageRaw = tokenImageRaw;
	}
	public long getAlignment() {
		return alignment;
	}
	public void setAlignment(long alignment) {
		this.alignment = alignment;
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
	public int getArmorClass() {
		return armorClass;
	}
	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
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
	public boolean isProeficientForce() {
		return proeficientForce;
	}
	public void setProeficientForce(boolean proeficientForce) {
		this.proeficientForce = proeficientForce;
	}
	public boolean isProeficientDexterity() {
		return proeficientDexterity;
	}
	public void setProeficientDexterity(boolean proeficientDexterity) {
		this.proeficientDexterity = proeficientDexterity;
	}
	public boolean isProeficientConstitution() {
		return proeficientConstitution;
	}
	public void setProeficientConstitution(boolean proeficientConstitution) {
		this.proeficientConstitution = proeficientConstitution;
	}
	public boolean isProeficientInteligence() {
		return proeficientInteligence;
	}
	public void setProeficientInteligence(boolean proeficientInteligence) {
		this.proeficientInteligence = proeficientInteligence;
	}
	public boolean isProeficientWisdom() {
		return proeficientWisdom;
	}
	public void setProeficientWisdom(boolean proeficientWisdom) {
		this.proeficientWisdom = proeficientWisdom;
	}
	public boolean isProeficientCharisma() {
		return proeficientCharisma;
	}
	public void setProeficientCharisma(boolean proeficientCharisma) {
		this.proeficientCharisma = proeficientCharisma;
	}
	public List<ActionCreateDTO> getActions() {
		return actions;
	}
	public void setActions(List<ActionCreateDTO> actions) {
		this.actions = actions;
	}
	public List<ActionCreateDTO> getLegendaryActions() {
		return legendaryActions;
	}
	public void setLegendaryActions(List<ActionCreateDTO> legendaryActions) {
		this.legendaryActions = legendaryActions;
	}
	
	
	
	
	
	
	
	
	
}
