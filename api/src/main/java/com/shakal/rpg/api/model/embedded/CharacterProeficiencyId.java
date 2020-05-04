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
	
	
}
