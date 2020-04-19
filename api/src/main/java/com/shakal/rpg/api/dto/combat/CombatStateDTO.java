package com.shakal.rpg.api.dto.combat;

import java.util.List;



public class CombatStateDTO {
	private List<CreatureCardDTO> creatures;
	private int dificult;
	private int userTypeInStory;
	
	
	
	
	
	public List<CreatureCardDTO> getCreatures() {
		return creatures;
	}
	public void setCreatures(List<CreatureCardDTO> creatures) {
		this.creatures = creatures;
	}
	public int getDificult() {
		return dificult;
	}
	public void setDificult(int dificult) {
		this.dificult = dificult;
	}
	public int getUserTypeInStory() {
		return userTypeInStory;
	}
	public void setUserTypeInStory(int userTypeInStory) {
		this.userTypeInStory = userTypeInStory;
	}
	
	
	
	
	
	
	
	
	
	

}
