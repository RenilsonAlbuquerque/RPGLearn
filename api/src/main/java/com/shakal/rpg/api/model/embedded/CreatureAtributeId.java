package com.shakal.rpg.api.model.embedded;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CreatureAtributeId implements Serializable {
	
	
	@Column(name = "creature_id")
    private Long creatureId;

    @Column(name = "atribute_id")
    private Long atributeId;

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
    
    
}
