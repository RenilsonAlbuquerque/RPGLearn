package com.shakal.rpg.api.dto.combat;

import java.util.List;



public class CombatStateDTO {
	private List<CreatureCardDTO> creatures;
	private List<CreatureCardDTO> allyQueue;
	private List<CreatureCardDTO> enemyQueue;
	private int dificult;
	private int userTypeInStory;
	
	
	
	
	
	public List<CreatureCardDTO> getCreatures() {
		return creatures;
	}
	public void setCreatures(List<CreatureCardDTO> creatures) {
		this.creatures = creatures;
	}
	
	public List<CreatureCardDTO> getAllyQueue() {
		return allyQueue;
	}
	public void setAllyQueue(List<CreatureCardDTO> allyQueue) {
		this.allyQueue = allyQueue;
	}
	public List<CreatureCardDTO> getEnemyQueue() {
		return enemyQueue;
	}
	public void setEnemyQueue(List<CreatureCardDTO> enemyQueue) {
		this.enemyQueue = enemyQueue;
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
