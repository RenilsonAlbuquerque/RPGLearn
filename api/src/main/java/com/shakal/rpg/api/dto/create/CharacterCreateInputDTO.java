package com.shakal.rpg.api.dto.create;

import java.util.List;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;

public class CharacterCreateInputDTO {

	private List<RaceCreateInputDTO> races;
	private List<ClassCreateInputDTO> classes;
	private List<KeyValueDTO> alignments;
	private List<KeyValueDTO> damageType;
	private List<KeyValueDTO> languages;
	
	public List<RaceCreateInputDTO> getRaces() {
		return races;
	}
	public void setRaces(List<RaceCreateInputDTO> races) {
		this.races = races;
	}
	public List<ClassCreateInputDTO> getClasses() {
		return classes;
	}
	public void setClasses(List<ClassCreateInputDTO> classes) {
		this.classes = classes;
	}
	public List<KeyValueDTO> getAlignments() {
		return alignments;
	}
	public void setAlignments(List<KeyValueDTO> alignments) {
		this.alignments = alignments;
	}
	public List<KeyValueDTO> getDamageType() {
		return damageType;
	}
	public void setDamageType(List<KeyValueDTO> damageType) {
		this.damageType = damageType;
	}
	public List<KeyValueDTO> getLanguages() {
		return languages;
	}
	public void setLanguages(List<KeyValueDTO> languages) {
		this.languages = languages;
	}
	
	
	
	
}
