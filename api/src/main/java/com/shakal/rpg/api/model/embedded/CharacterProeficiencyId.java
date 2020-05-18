package com.shakal.rpg.api.model.embedded;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CharacterProeficiencyId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "character_Id")
    private Long characterId;
	
	@Column(name = "proeficiency_Id")
    private Long proeficiencyId;

	public Long getCharacterId() {
		return characterId;
	}

	public void setCharacterId(Long characterId) {
		this.characterId = characterId;
	}

	public Long getProeficiencyId() {
		return proeficiencyId;
	}

	public void setProeficiencyId(Long proeficiencyId) {
		this.proeficiencyId = proeficiencyId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((characterId == null) ? 0 : characterId.hashCode());
		result = prime * result + ((proeficiencyId == null) ? 0 : proeficiencyId.hashCode());
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
		CharacterProeficiencyId other = (CharacterProeficiencyId) obj;
		if (characterId == null) {
			if (other.characterId != null)
				return false;
		} else if (!characterId.equals(other.characterId))
			return false;
		if (proeficiencyId == null) {
			if (other.proeficiencyId != null)
				return false;
		} else if (!proeficiencyId.equals(other.proeficiencyId))
			return false;
		return true;
	}
	
	
}
