package com.shakal.rpg.api.model.relation;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.shakal.rpg.api.model.Atribute;
import com.shakal.rpg.api.model.Character;
import com.shakal.rpg.api.model.Creature;
import com.shakal.rpg.api.model.Weapon;
import com.shakal.rpg.api.model.embedded.CharacterWeaponId;
import com.shakal.rpg.api.model.embedded.CreatureAtributeId;

@Entity
@Table(name= "mtm_creature_atribute")
public class CreatureAtribute {

	@EmbeddedId
	private CreatureAtributeId id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@MapsId("creatureId")
	private Creature creature;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@MapsId("atributeId")
	private Atribute atribute;
	
	private boolean proeficiency;
	
	private int value;
	
	private int modfier;

	public CreatureAtributeId getId() {
		return id;
	}

	public void setId(CreatureAtributeId id) {
		this.id = id;
	}

	public Creature getCreature() {
		return creature;
	}

	public void setCreature(Creature creature) {
		this.creature = creature;
	}

	public Atribute getAtribute() {
		return atribute;
	}

	public void setAtribute(Atribute atribute) {
		this.atribute = atribute;
	}

	public boolean isProeficiency() {
		return proeficiency;
	}

	public void setProeficiency(boolean proeficiency) {
		this.proeficiency = proeficiency;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getModfier() {
		return modfier;
	}

	public void setModfier(int modfier) {
		this.modfier = modfier;
	}
	
	
}
