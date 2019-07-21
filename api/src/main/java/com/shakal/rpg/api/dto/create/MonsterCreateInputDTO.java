package com.shakal.rpg.api.dto.create;

import java.util.List;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;

public class MonsterCreateInputDTO {

	public List<KeyValueDTO> languages;
	public List<KeyValueDTO> levels;

	public List<KeyValueDTO> getLanguages() {
		return languages;
	}

	public void setLanguages(List<KeyValueDTO> languages) {
		this.languages = languages;
	}

	public List<KeyValueDTO> getLevels() {
		return levels;
	}

	public void setLevels(List<KeyValueDTO> levels) {
		this.levels = levels;
	}
	
	
	
}
