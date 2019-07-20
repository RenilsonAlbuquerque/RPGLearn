package com.shakal.rpg.api.dto.create;

import java.util.List;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;

public class MonsterCreateInputDTO {

	public List<KeyValueDTO> languages;

	public List<KeyValueDTO> getLanguages() {
		return languages;
	}

	public void setLanguages(List<KeyValueDTO> languages) {
		this.languages = languages;
	}
	
	
	
}
