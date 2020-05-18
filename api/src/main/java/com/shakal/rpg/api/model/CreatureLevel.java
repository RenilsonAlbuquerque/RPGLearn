package com.shakal.rpg.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "tb_creature_level")
public class CreatureLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private double value;
	
	private int experiencePoints;
	
	private int proeficiencyBonus;
	
	public CreatureLevel() {
		
	}
	public CreatureLevel(long id) {
		this.setId(id);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
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
