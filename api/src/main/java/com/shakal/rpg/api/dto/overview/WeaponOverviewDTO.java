package com.shakal.rpg.api.dto.overview;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;

public class WeaponOverviewDTO {

	private long id;
	
	private String name;
	
	private KeyValueDTO category;
	
	private KeyValueDTO classification;
	
	private KeyValueDTO range;

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
	
	
	
}
