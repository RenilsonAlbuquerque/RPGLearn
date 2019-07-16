package com.shakal.rpg.api.model.embedded;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CharacterWeaponId implements Serializable {


    @Column(name = "character_id")
    private Long characterId;
    
	@Column(name = "weapon_id")
    private Long weaponId;

	public Long getCharacterId() {
		return characterId;
	}

	public void setCharacterId(Long characterId) {
		this.characterId = characterId;
	}

	public Long getWeaponId() {
		return weaponId;
	}

	public void setWeaponId(Long weaponId) {
		this.weaponId = weaponId;
	}

	
	
}
