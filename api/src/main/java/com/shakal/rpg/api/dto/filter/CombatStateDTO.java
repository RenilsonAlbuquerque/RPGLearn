package com.shakal.rpg.api.dto.filter;

import java.util.List;

import com.shakal.rpg.api.dto.overview.MonsterCardDTO;

public class CombatStateDTO {
	private List<MonsterCardDTO> monsters;
	private List<MonsterCardDTO> players;
	private int dificult;
	
	
	
	public List<MonsterCardDTO> getMonsters() {
		return monsters;
	}
	public void setMonsters(List<MonsterCardDTO> monsters) {
		this.monsters = monsters;
	}
	public List<MonsterCardDTO> getPlayers() {
		return players;
	}
	public void setPlayers(List<MonsterCardDTO> players) {
		this.players = players;
	}
	public int getDificult() {
		return dificult;
	}
	public void setDificult(int dificult) {
		this.dificult = dificult;
	}
	
	
	
	
	
	
	
	
	

}
