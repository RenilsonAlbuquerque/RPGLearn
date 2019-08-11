package com.shakal.rpg.api.model.embedded;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CreatureResistenceId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "creature_id")
    private Long creatureId;

    @Column(name = "damage_type_id")
    private Long damageTypeId;
    
    
    

    public CreatureResistenceId() {
    	
    }
    
    
	public CreatureResistenceId(Long creatureId, Long damageTypeId) {
		super();
		this.creatureId = creatureId;
		this.damageTypeId = damageTypeId;
	}

	public Long getMonsterId() {
		return creatureId;
	}

	public void setMonsterId(Long creatureId) {
		this.creatureId = creatureId;
	}

	public Long getDamageTypeId() {
		return damageTypeId;
	}

	public void setDamageTypeId(Long damageTypeId) {
		this.damageTypeId = damageTypeId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creatureId == null) ? 0 : creatureId.hashCode());
		result = prime * result + ((damageTypeId == null) ? 0 : damageTypeId.hashCode());
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
		CreatureResistenceId other = (CreatureResistenceId) obj;
		if (creatureId == null) {
			if (other.creatureId != null)
				return false;
		} else if (!creatureId.equals(other.creatureId))
			return false;
		if (damageTypeId == null) {
			if (other.damageTypeId != null)
				return false;
		} else if (!damageTypeId.equals(other.damageTypeId))
			return false;
		return true;
	}
    
    
}
