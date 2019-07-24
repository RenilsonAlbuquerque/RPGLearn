package com.shakal.rpg.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "tb_monster_challenge_level")
public class MonsterChallengeLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private int value;
	
	private int experiencePoints;
	
	private int proeficiencyBonus;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getExperiencePoints() {
		return experiencePoints;
	}

	public void setExperiencePoints(int experiencePoints) {
		this.experiencePoints = experiencePoints;
	}

	public int getProeficiencyBonus() {
		return proeficiencyBonus;
	}

	public void setProeficiencyBonus(int proeficiencyBonus) {
		this.proeficiencyBonus = proeficiencyBonus;
	}

	
	
	
}
