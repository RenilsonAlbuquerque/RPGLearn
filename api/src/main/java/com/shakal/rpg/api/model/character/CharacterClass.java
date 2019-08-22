package com.shakal.rpg.api.model.character;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.shakal.rpg.api.model.CreatureLevel;
import com.shakal.rpg.api.model.embedded.CharacterClassLevelId;

@Entity
@Table(name= "mtm_character_class")
public class CharacterClass {

	@Id
	@EmbeddedId
	private CharacterClassLevelId id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name = "character_id",referencedColumnName = "creature_id")
	@MapsId("characterId")
	private Character character;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@MapsId("classId")
	private Class clasS;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@MapsId("levelId")
	private CreatureLevel level;
	

	public CharacterClassLevelId getId() {
		return id;
	}

	public void setId(CharacterClassLevelId id) {
		this.id = id;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Class getClasS() {
		return clasS;
	}

	public void setClasS(Class clasS) {
		this.clasS = clasS;
	}

	public CreatureLevel getLevel() {
		return level;
	}

	public void setLevel(CreatureLevel level) {
		this.level = level;
	}
	
	
	
}
