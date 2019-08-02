package com.shakal.rpg.api.dto.create;

import java.util.List;

import com.shakal.rpg.api.dto.commons.KeyNameDescriptionDto;
import com.shakal.rpg.api.dto.commons.KeyValueDTO;

public class MonsterCreateInputDTO {

	private List<KeyValueDTO> alignments;
	private List<KeyValueDTO> sizes;
	private List<KeyNameDescriptionDto> types;
	private List<KeyValueDTO> damageType;
	private List<KeyValueDTO> languages;
	private List<KeyValueDTO> levels;
	private List<KeyValueDTO> dices;
	

	
	
	public List<KeyValueDTO> getAlignments() {
		return alignments;
	}

	public void setAlignments(List<KeyValueDTO> alignments) {
		this.alignments = alignments;
	}

	public List<KeyValueDTO> getSizes() {
		return sizes;
	}

	public void setSizes(List<KeyValueDTO> sizes) {
		this.sizes = sizes;
	}

	public List<KeyNameDescriptionDto> getTypes() {
		return types;
	}

	public void setTypes(List<KeyNameDescriptionDto> types) {
		this.types = types;
	}

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

	public List<KeyValueDTO> getDamageType() {
		return damageType;
	}

	public void setDamageType(List<KeyValueDTO> damageType) {
		this.damageType = damageType;
	}

	public List<KeyValueDTO> getDices() {
		return dices;
	}

	public void setDices(List<KeyValueDTO> dices) {
		this.dices = dices;
	}
	
	
	
	
}
