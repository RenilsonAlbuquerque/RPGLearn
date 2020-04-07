package com.shakal.rpg.api.model.character;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.shakal.rpg.api.model.embedded.CharacterClassLevelId;


@Entity
@Table(name= "mtm_character_class_level")
public class CharacterClassLevel {
	
	@Id
	@EmbeddedId
	private CharacterClassLevelId id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name = "character_id",referencedColumnName = "creature_id")
	@MapsId("characterId")
	private Character character;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumns({
        @JoinColumn(name = "class_id", referencedColumnName = "class_id",insertable=false, updatable=false),
        @JoinColumn(name = "level_id", referencedColumnName = "level_id",insertable=false, updatable=false)
	})
	private ClassLevel classLevel;
	
	

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

	public ClassLevel getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(ClassLevel classLevel) {
		this.classLevel = classLevel;
	}

	
}
