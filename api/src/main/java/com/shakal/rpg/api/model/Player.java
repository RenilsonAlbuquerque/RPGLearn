package com.shakal.rpg.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "tb_player")
public class Player extends Role {
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Character> character;
	
	

	public List<Character> getCharacter() {
		return character;
	}

	public void setCharacter(List<Character> character) {
		this.character = character;
	}
	
	
	

}
