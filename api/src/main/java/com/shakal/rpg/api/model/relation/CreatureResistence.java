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

import com.shakal.rpg.api.model.Creature;
import com.shakal.rpg.api.model.DamageType;

import com.shakal.rpg.api.model.embedded.CreatureResistenceId;
import com.shakal.rpg.api.model.enums.ResistenceTypeEnum;

@Entity
@Table(name= "mtm_creature_resistence")
public class CreatureResistence {

	@EmbeddedId
	private CreatureResistenceId id;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade ={CascadeType.PERSIST, CascadeType.MERGE}  )
	@MapsId("creatureId")
	private Creature creature;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creature == null) ? 0 : creature.hashCode());
		result = prime * result + ((damageType == null) ? 0 : damageType.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreatureResistence other = (CreatureResistence) obj;
		if (creature == null) {
			if (other.creature != null)
				return false;
		} else if (!creature.equals(other.creature))
			return false;
		if (damageType == null) {
			if (other.damageType != null)
				return false;
		} else if (!damageType.equals(other.damageType))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	
	
}
