package com.shakal.rpg.api.model.embedded;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class WeaponDiceId implements Serializable {
	
	
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
    
    
    
    

}
