package com.shakal.rpg.api.model.combatstate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "tb_combat_state")
public class CombatState {
	
	@Id
	private long storyId;
	
	@Column(length=15000)
	private String combatStateJSON;

	public CombatState() {
		
	}
	public CombatState(long id, String combatStateJson) {
		this.storyId = id;
		this.combatStateJSON = combatStateJson;
	}
	
	public long getStoryId() {
		return storyId;
	}

	public void setStoryId(long storyId) {
		this.storyId = storyId;
	}

	public String getCombatStateJSON() {
		return combatStateJSON;
	}

	public void setCombatStateJSON(String combatStateJSON) {
		this.combatStateJSON = combatStateJSON;
	}
	
	

}
