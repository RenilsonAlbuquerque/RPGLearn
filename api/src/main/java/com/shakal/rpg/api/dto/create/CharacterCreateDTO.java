package com.shakal.rpg.api.dto.create;

import java.util.List;

public class CharacterCreateDTO {
	
	private long userId;
	private long storyId;
	
	private String imagePath;
	private String tokenImageRaw;
	private String name;
	private String publicBackground;
	private String secretBackground;
	
	private int strength;
	private int dexterity;
	private int constitution;
	private int inteligence;
	private int wisdom;
	private int charisma;
	
	private List<Long> proeficiencies;
	
	private int age;
	private int height;
	private int weight;
	private long alignment;
	private long classs;
	private long race;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getStoryId() {
		return storyId;
	}
	public void setStoryId(long storyId) {
		this.storyId = storyId;
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
	public String getPublicBackground() {
		return publicBackground;
	}
	public void setPublicBackground(String publicBackground) {
		this.publicBackground = publicBackground;
	}
	public String getSecretBackground() {
		return secretBackground;
	}
	public void setSecretBackground(String secretBackground) {
		this.secretBackground = secretBackground;
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
	public long getAlignment() {
		return alignment;
	}
	public void setAlignment(long alignment) {
		this.alignment = alignment;
	}
	public long getClasss() {
		return classs;
	}
	public void setClasss(long classs) {
		this.classs = classs;
	}
	public long getRace() {
		return race;
	}
	public void setRace(long race) {
		this.race = race;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
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
	public String getTokenImageRaw() {
		return tokenImageRaw;
	}
	public void setTokenImageRaw(String tokenImageRaw) {
		this.tokenImageRaw = tokenImageRaw;
	}
	public List<Long> getProeficiencies() {
		return proeficiencies;
	}
	public void setProeficiencies(List<Long> proeficiencies) {
		this.proeficiencies = proeficiencies;
	}
	
	
	

	
	
}
