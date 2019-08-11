package com.shakal.rpg.api.model.embedded;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AttackDiceId implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "attack_id")
    private Long attackId;

    @Column(name = "dice_id")
    private Long diceId;

    
    
	public AttackDiceId() {
		super();
	}

	public AttackDiceId(Long attackId, Long diceId) {
		super();
		this.attackId = attackId;
		this.diceId = diceId;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attackId == null) ? 0 : attackId.hashCode());
		result = prime * result + ((diceId == null) ? 0 : diceId.hashCode());
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
		AttackDiceId other = (AttackDiceId) obj;
		if (attackId == null) {
			if (other.attackId != null)
				return false;
		} else if (!attackId.equals(other.attackId))
			return false;
		if (diceId == null) {
			if (other.diceId != null)
				return false;
		} else if (!diceId.equals(other.diceId))
			return false;
		return true;
	}
    
    
}
