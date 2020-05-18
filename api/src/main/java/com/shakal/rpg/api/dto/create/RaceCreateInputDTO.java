package com.shakal.rpg.api.dto.create;

import java.util.List;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;

public class RaceCreateInputDTO {
	private long id;
	private String name;
	private List<KeyValueDTO> subRaces;
	
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
	public List<KeyValueDTO> getSubRaces() {
		return subRaces;
	}
	public void setSubRaces(List<KeyValueDTO> subRaces) {
		this.subRaces = subRaces;
	}
	
}
