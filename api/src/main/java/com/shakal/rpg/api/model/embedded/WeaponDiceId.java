package com.shakal.rpg.api.model.embedded;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class WeaponDiceId implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "weapon_id")
    private Long weaponId;

    @Column(name = "dice_id")
    private Long diceId;
    
    

	public Long getWeaponId() {
		return weaponId;
	}

	public void setWeaponId(Long weaponId) {
		this.weaponId = weaponId;
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
		result = prime * result + ((diceId == null) ? 0 : diceId.hashCode());
		result = prime * result + ((weaponId == null) ? 0 : weaponId.hashCode());
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
		WeaponDiceId other = (WeaponDiceId) obj;
		if (diceId == null) {
			if (other.diceId != null)
				return false;
		} else if (!diceId.equals(other.diceId))
			return false;
		if (weaponId == null) {
			if (other.weaponId != null)
				return false;
		} else if (!weaponId.equals(other.weaponId))
			return false;
		return true;
	}
    
    
    
    

}
