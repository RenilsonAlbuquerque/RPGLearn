package com.shakal.rpg.api.model.embedded;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CharacterWeaponId implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((characterId == null) ? 0 : characterId.hashCode());
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
		CharacterWeaponId other = (CharacterWeaponId) obj;
		if (characterId == null) {
			if (other.characterId != null)
				return false;
		} else if (!characterId.equals(other.characterId))
			return false;
		if (weaponId == null) {
			if (other.weaponId != null)
				return false;
		} else if (!weaponId.equals(other.weaponId))
			return false;
		return true;
	}

	
	
}
