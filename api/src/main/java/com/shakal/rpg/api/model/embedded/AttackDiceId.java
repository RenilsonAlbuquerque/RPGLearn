package com.shakal.rpg.api.model.embedded;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AttackDiceId implements Serializable {
	
	
	@Column(name = "attack_id")
    private Long attackId;

    @Column(name = "dice_id")
    private Long diceId;

	public Long getAttackId() {
		return attackId;
	}

	public void setAttackId(Long attackId) {
		this.attackId = attackId;
	}

	public Long getDiceId() {
		return diceId;
	}

	public void setDiceId(Long diceId) {
		this.diceId = diceId;
	}
    
    
}
