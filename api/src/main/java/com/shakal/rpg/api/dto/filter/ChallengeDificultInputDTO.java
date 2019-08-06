package com.shakal.rpg.api.dto.filter;

import java.util.List;

import com.shakal.rpg.api.dto.commons.DoubleInt;

public class ChallengeDificultInputDTO {
	private List<DoubleInt> monsters;
	private List<DoubleInt> players;
	private int challengeLevel;
	
	
	
	public List<DoubleInt> getMonsters() {
		return monsters;
	}
	public void setMonsters(List<DoubleInt> monsters) {
		this.monsters = monsters;
	}
	public List<DoubleInt> getPlayers() {
		return players;
	}
	public void setPlayers(List<DoubleInt> players) {
		this.players = players;
	}
	public int getChallengeLevel() {
		return challengeLevel;
	}
	public void setChallengeLevel(int challengeLevel) {
		this.challengeLevel = challengeLevel;
	}
	
	
	
	

}
