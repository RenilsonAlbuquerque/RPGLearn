package com.shakal.rpg.api.dto.info;

import java.util.List;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.overview.BagOverviewDTO;
import com.shakal.rpg.api.dto.overview.ClassLevelOveriewDTO;

public class CharacterSheetDTO {

	private long id;
	private String imagePath;
	private String name;
	private String background;
	private List<ClassLevelOveriewDTO> classLevels;
	private KeyValueDTO race;
	private KeyValueDTO alignment;
	private KeyValueDTO player;
	
	private AtributeInfoDTO strength;
	private AtributeInfoDTO dexterity;
	private AtributeInfoDTO constitution;
	private AtributeInfoDTO wisdom;
	private AtributeInfoDTO inteligence;
	private AtributeInfoDTO charisma;
	
	private List<ViewAtributeInfoDTO> savins;
	
	private List<ViewAtributeInfoDTO> proeficiencies;
	
	private List<KeyValueDTO> languages;

	private int inspiration;
	private int proeficiencBonus;
	
	private int age;
	private int height;
	private int weight;
	private int experiencyPoints;
	
	private int armorClass;
	private int initiative;
	private int speed;
	
	private CharacterLifePointsDTO lifePoints;
	
	private BagOverviewDTO bag;
	
	 
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public KeyValueDTO getAlignment() {
		return alignment;
	}
	public void setAlignment(KeyValueDTO alignment) {
		this.alignment = alignment;
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public List<ClassLevelOveriewDTO> getClassLevels() {
		return classLevels;
	}
	public void setClassLevels(List<ClassLevelOveriewDTO> classLevels) {
		this.classLevels = classLevels;
	}
	public KeyValueDTO getRace() {
		return race;
	}
	public void setRace(KeyValueDTO race) {
		this.race = race;
	}
	public int getExperiencyPoints() {
		return experiencyPoints;
	}
	public void setExperiencyPoints(int experiencyPoints) {
		this.experiencyPoints = experiencyPoints;
	}
	public KeyValueDTO getPlayer() {
		return player;
	}
	public void setPlayer(KeyValueDTO player) {
		this.player = player;
	}
	public int getProeficiencBonus() {
		return proeficiencBonus;
	}
	public void setProeficiencBonus(int proeficiencBonus) {
		this.proeficiencBonus = proeficiencBonus;
	}
	public CharacterLifePointsDTO getLifePoints() {
		return lifePoints;
	}
	public void setLifePoints(CharacterLifePointsDTO lifePoints) {
		this.lifePoints = lifePoints;
	}
	public AtributeInfoDTO getStrength() {
		return strength;
	}
	public void setStrength(AtributeInfoDTO strength) {
		this.strength = strength;
	}
	public AtributeInfoDTO getDexterity() {
		return dexterity;
	}
	public void setDexterity(AtributeInfoDTO dexterity) {
		this.dexterity = dexterity;
	}
	public AtributeInfoDTO getConstitution() {
		return constitution;
	}
	public void setConstitution(AtributeInfoDTO constitution) {
		this.constitution = constitution;
	}
	public AtributeInfoDTO getWisdom() {
		return wisdom;
	}
	public void setWisdom(AtributeInfoDTO wisdom) {
		this.wisdom = wisdom;
	}
	public AtributeInfoDTO getInteligence() {
		return inteligence;
	}
	public void setInteligence(AtributeInfoDTO inteligence) {
		this.inteligence = inteligence;
	}
	public AtributeInfoDTO getCharisma() {
		return charisma;
	}
	public void setCharisma(AtributeInfoDTO charisma) {
		this.charisma = charisma;
	}
	public int getArmorClass() {
		return armorClass;
	}
	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}
	public int getInitiative() {
		return initiative;
	}
	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}
	public List<KeyValueDTO> getLanguages() {
		return languages;
	}
	public void setLanguages(List<KeyValueDTO> languages) {
		this.languages = languages;
	}
	public List<ViewAtributeInfoDTO> getProeficiencies() {
		return proeficiencies;
	}
	public void setProeficiencies(List<ViewAtributeInfoDTO> proeficiencies) {
		this.proeficiencies = proeficiencies;
	}
	public List<ViewAtributeInfoDTO> getSavins() {
		return savins;
	}
	public void setSavins(List<ViewAtributeInfoDTO> savins) {
		this.savins = savins;
	}
	public int getInspiration() {
		return inspiration;
	}
	public void setInspiration(int inspiration) {
		this.inspiration = inspiration;
	}
	public BagOverviewDTO getBag() {
		return bag;
	}
	public void setBag(BagOverviewDTO bag) {
		this.bag = bag;
	}
	
	
	
}
