package com.shakal.rpg.api.dto.combat;

import java.util.List;

import com.shakal.rpg.api.dto.overview.MonsterCardDTO;

public class CombatStateDTO {
	private List<MonsterCardDTO> monsters;
	private List<PlayerCardDTO> players;
	private int dificult;
	private int userTypeInStory;
	
	
	
	public List<MonsterCardDTO> getMonsters() {
		return monsters;
	}
	public void setMonsters(List<MonsterCardDTO> monsters) {
		this.monsters = monsters;
	}
	
	public List<PlayerCardDTO> getPlayers() {
		return players;
	}
	public void setPlayers(List<PlayerCardDTO> players) {
		this.players = players;
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
