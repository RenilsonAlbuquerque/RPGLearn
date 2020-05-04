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

import com.shakal.rpg.api.model.creature.Proeficiency;
import com.shakal.rpg.api.model.embedded.CharacterProeficiencyId;

@Entity
@Table(name= "mtm_character_proeficiency")
public class CharacterProeficiency {
	
	@Id
	@EmbeddedId
	private CharacterProeficiencyId id;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Character.class)
	@JoinColumn(name ="race_id", referencedColumnName = "creature_id")
	@MapsId("characterId")
	private Character character;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Proeficiency.class)
	@MapsId("proeficiencyId")
	private Proeficiency proeficiency;

	
	public CharacterProeficiencyId getId() {
		return id;
	}

	public void setId(CharacterProeficiencyId id) {
		this.id = id;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Proeficiency getProeficiency() {
		return proeficiency;
	}

	public void setProeficiency(Proeficiency proeficiency) {
		this.proeficiency = proeficiency;
	}
	
	
	

}
