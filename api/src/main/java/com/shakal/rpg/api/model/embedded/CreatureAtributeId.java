package com.shakal.rpg.api.model.embedded;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CreatureAtributeId implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "creature_id")
    private Long creatureId;

    @Column(name = "atribute_id")
    private Long atributeId;

    public CreatureAtributeId() {
    	
    }
    public CreatureAtributeId(long atributeId, long creatureId) {
    	this.atributeId = atributeId;
    	this.creatureId = creatureId;
    }
	public Long getCreatureId() {
		return creatureId;
	}

	public void setCreatureId(Long creatureId) {
		this.creatureId = creatureId;
	}

	public Long getAtributeId() {
		return atributeId;
	}

	public void setAtributeId(Long atributeId) {
		this.atributeId = atributeId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atributeId == null) ? 0 : atributeId.hashCode());
		result = prime * result + ((creatureId == null) ? 0 : creatureId.hashCode());
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
		CreatureAtributeId other = (CreatureAtributeId) obj;
		if (atributeId == null) {
			if (other.atributeId != null)
				return false;
		} else if (!atributeId.equals(other.atributeId))
			return false;
		if (creatureId == null) {
			if (other.creatureId != null)
				return false;
		} else if (!creatureId.equals(other.creatureId))
			return false;
		return true;
	}
    
    
}
