package com.shakal.rpg.api.model.embedded;

import java.io.Serializable;

import javax.persistence.Column;

public class CharacterRoleId implements Serializable {


    @Column(name = "character_id")
    private Long characterId;
    
	@Column(name = "role_id")
    private Long roleId;
}
