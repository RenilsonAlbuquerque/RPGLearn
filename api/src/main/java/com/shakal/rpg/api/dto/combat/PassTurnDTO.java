package com.shakal.rpg.api.dto.combat;

public class PassTurnDTO {

	private String combatId;
	private long storyId;
	
	public String getCombatId() {
		return combatId;
	}
	public void setCombatId(String combatId) {
		this.combatId = combatId;
	}
	public long getStoryId() {
		return storyId;
	}
	public void setStoryId(long storyId) {
		this.storyId = storyId;
	}
	
}
