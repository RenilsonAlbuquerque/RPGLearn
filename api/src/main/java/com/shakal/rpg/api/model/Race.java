package com.shakal.rpg.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.shakal.rpg.api.model.character.CharacterRaceAtributeBonus;
import com.shakal.rpg.api.model.character.SubRace;

@Entity
@Table(name= "tb_race")
public class Race {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@Column(length = 500)
	private String description;
	
	private int speed;
	
	@OneToMany(mappedBy = "race",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY, targetEntity = SubRace.class)
	private List<SubRace> subRaces;
	
	@OneToMany(mappedBy = "race",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY, targetEntity = CharacterRaceAtributeBonus.class)
	private List<CharacterRaceAtributeBonus> atributeBonus;
	
	@Column(length = 700)
	private String languages;
	
	@Column(length = 700)
	private String age;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name ="size_id")
	private MonsterSize size;
	
	@Column(length = 700)
	private String sizeDescription;
	
	public Race() {
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<SubRace> getSubRaces() {
		return subRaces;
	}


	public void setSubRaces(List<SubRace> subRaces) {
		this.subRaces = subRaces;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public List<CharacterRaceAtributeBonus> getAtributeBonus() {
		return atributeBonus;
	}


	public void setAtributeBonus(List<CharacterRaceAtributeBonus> atributeBonus) {
		this.atributeBonus = atributeBonus;
	}
	
	
	
}
