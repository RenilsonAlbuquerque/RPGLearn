package com.shakal.rpg.api.dto;

import java.util.List;

public class MonsterActionDTO {

	private String name;
	private String description;
	private List<String> damage;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getDamage() {
		return damage;
	}
	public void setDamage(List<String> damage) {
		this.damage = damage;
	}
	
	
	
}
