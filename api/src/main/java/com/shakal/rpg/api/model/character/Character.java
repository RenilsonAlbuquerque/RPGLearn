package com.shakal.rpg.api.model.character;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.shakal.rpg.api.model.Creature;
import com.shakal.rpg.api.model.Race;
import com.shakal.rpg.api.model.creature.Proeficiency;
import com.shakal.rpg.api.model.enums.SexEnum;
import com.shakal.rpg.api.model.relation.UserStory;

@Entity
@Table(name= "tb_character")
@PrimaryKeyJoinColumn(name = "creature_id")
public class Character extends Creature implements Serializable{
	
	private String name;
	
	private int age;
	
	@Enumerated(EnumType.STRING)
	private SexEnum sex;
	
	private int height;
	
	private int weight;
	
	@Column(length = 5000)
	private String backgroundStory;
	
	private int armorClass;
	
	private int speed;
	
	private int lifePoints;
	
	private int experiencyPoints;
	
	@OneToMany(mappedBy = "character",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<UserStory> userStory;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="race_id")
	private Race race;
	
	@OneToMany(mappedBy = "character",fetch = FetchType.LAZY)
	private List<CharacterClassLevel> classLevel;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Proeficiency.class)
    @JoinTable(name = "mtm_character_proeficiency",
            joinColumns = @JoinColumn(name = "character_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "proeficiency_id", referencedColumnName = "id"))
    private List<Proeficiency> proeficiencies;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public SexEnum getSex() {
		return sex;
	}

	public void setSex(SexEnum sex) {
		this.sex = sex;
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

	public String getBackgroundStory() {
		return backgroundStory;
	}

	public void setBackgroundStory(String backgroundStory) {
		this.backgroundStory = backgroundStory;
	}

	public int getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}

	public List<UserStory> getUserStory() {
		return userStory;
	}

	public void setUserStory(List<UserStory> userStory) {
		this.userStory = userStory;
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

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	

	public List<CharacterClassLevel> getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(List<CharacterClassLevel> classLevel) {
		this.classLevel = classLevel;
	}

	public List<Proeficiency> getProeficiencies() {
		return proeficiencies;
	}

	public void setProeficiencies(List<Proeficiency> proeficiencies) {
		this.proeficiencies = proeficiencies;
	}

	public int getExperiencyPoints() {
		return experiencyPoints;
	}

	public void setExperiencyPoints(int experiencyPoints) {
		this.experiencyPoints = experiencyPoints;
	}
	
	
	

}
