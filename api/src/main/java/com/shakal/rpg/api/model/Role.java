package com.shakal.rpg.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.shakal.rpg.api.model.relation.CharacterRole;


@Entity
@Table(name= "tb_role")
@Inheritance(strategy = InheritanceType.JOINED)
public class Role {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	
	
	@OneToMany(mappedBy = "role",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CharacterRole> character;
	
	

	

	
	public List<CharacterRole> getCharacter() {
		return character;
	}

	public void setCharacter(List<CharacterRole> character) {
		this.character = character;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
	
}
