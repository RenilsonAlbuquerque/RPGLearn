package com.shakal.rpg.api.dto.create;

import java.util.List;

public class ActionCreateDTO {

	 private String name;
	 private String description;
	 private List<DamageDiceDTO> damages;
	 
	 
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
	public List<DamageDiceDTO> getDamages() {
		return damages;
	}
	public void setDamages(List<DamageDiceDTO> damages) {
		this.damages = damages;
	}
	
	 
	 
}
