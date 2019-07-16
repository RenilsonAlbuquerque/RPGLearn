package com.shakal.rpg.api.model.relation;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.shakal.rpg.api.model.Character;
import com.shakal.rpg.api.model.Role;
import com.shakal.rpg.api.model.embedded.CharacterRoleId;
import com.shakal.rpg.api.model.enums.LifeStatusEnum;

@Entity
@Table(name= "mtm_character_role")
public class CharacterRole {

	@EmbeddedId
	private CharacterRoleId id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@MapsId("characterId")
	private Character character;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@MapsId("roleId")
	private Role role;
	
	@Enumerated(EnumType.STRING)
	private LifeStatusEnum status;

	public CharacterRoleId getId() {
		return id;
	}

	public void setId(CharacterRoleId id) {
		this.id = id;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public LifeStatusEnum getStatus() {
		return status;
	}

	public void setStatus(LifeStatusEnum status) {
		this.status = status;
	}
	
	
}
