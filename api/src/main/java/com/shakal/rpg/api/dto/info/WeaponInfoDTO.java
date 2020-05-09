package com.shakal.rpg.api.dto.info;

import java.util.List;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;

public class WeaponInfoDTO {

	private long id;
	private String imagePath;
	private String name;
	private String description;
	private double weight;
	private KeyValueDTO rarity;
	private CostInfoDTO cost;
	private KeyValueDTO category;
	private KeyValueDTO classification;
	private KeyValueDTO range;
	private List<DamageInfoDTO> damage;
	private int bonus;

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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public KeyValueDTO getCategory() {
		return category;
	}

	public void setCategory(KeyValueDTO category) {
		this.category = category;
	}

	public KeyValueDTO getClassification() {
		return classification;
	}

	public void setClassification(KeyValueDTO classification) {
		this.classification = classification;
	}

	public KeyValueDTO getRange() {
		return range;
	}

	public void setRange(KeyValueDTO range) {
		this.range = range;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public CostInfoDTO getCost() {
		return cost;
	}

	public void setCost(CostInfoDTO cost) {
		this.cost = cost;
	}

	public KeyValueDTO getRarity() {
		return rarity;
	}

	public void setRarity(KeyValueDTO rarity) {
		this.rarity = rarity;
	}

	public List<DamageInfoDTO> getDamage() {
		return damage;
	}

	public void setDamage(List<DamageInfoDTO> damage) {
		this.damage = damage;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	
	
	
	
}
