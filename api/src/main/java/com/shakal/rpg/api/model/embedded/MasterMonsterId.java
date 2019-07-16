package com.shakal.rpg.api.model.embedded;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MasterMonsterId implements Serializable {


    @Column(name = "master_id")
    private Long masterId;
    
	@Column(name = "monster_id")
    private Long monsterId;

	public Long getMassterId() {
		return masterId;
	}

	public void setMassterId(Long masterId) {
		this.masterId = masterId;
	}

	public Long getMonsterId() {
		return monsterId;
	}

	public void setMonsterId(Long monsterId) {
		this.monsterId = monsterId;
	}

	
}
