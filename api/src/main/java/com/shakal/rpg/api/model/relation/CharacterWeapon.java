package com.shakal.rpg.api.model.relation;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.shakal.rpg.api.model.Character;
import com.shakal.rpg.api.model.Weapon;
import com.shakal.rpg.api.model.embedded.CharacterWeaponId;

@Entity
@Table(name= "mtm_character_weapon")
public class CharacterWeapon {

	@EmbeddedId
	private CharacterWeaponId id;
	

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@MapsId("characterId")
	private Character character;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@MapsId("weaponId")
	private Weapon weapon;

	public CharacterWeaponId getId() {
		return id;
	}

	public void setId(CharacterWeaponId id) {
		this.id = id;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	
}
