package com.shakal.rpg.api.model.embedded;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CreatureResistenceId implements Serializable{

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
    
    
}
