package com.shakal.rpg.api.model.relation;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.shakal.rpg.api.model.Creature;
import com.shakal.rpg.api.model.DamageType;

import com.shakal.rpg.api.model.embedded.CreatureResistenceId;
import com.shakal.rpg.api.model.enums.ResistenceTypeEnum;

@Entity
@Table(name= "mtm_creature_resistence")
public class CreatureResistence {

	@EmbeddedId
	private CreatureResistenceId id;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
	@MapsId("creatureId")
	private Creature creature;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
	@MapsId("damageTypeId")
	private DamageType damageType;
	
	
	@Enumerated(EnumType.ORDINAL)
	private ResistenceTypeEnum type;
	


	public CreatureResistenceId getId() {
		return id;
	}

	public void setId(CreatureResistenceId id) {
		this.id = id;
	}



	public Creature getCreature() {
		return creature;
	}

	public void setCreature(Creature creature) {
		this.creature = creature;
	}

	public DamageType getDamageType() {
		return damageType;
	}

	public void setDamageType(DamageType damageType) {
		this.damageType = damageType;
	}

	public ResistenceTypeEnum getType() {
		return type;
	}

	public void setType(ResistenceTypeEnum type) {
		this.type = type;
	}
	
	
	
}
