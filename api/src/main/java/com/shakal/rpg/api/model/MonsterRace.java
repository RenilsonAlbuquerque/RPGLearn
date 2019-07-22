package com.shakal.rpg.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "tb_monster_race")
public class MonsterRace {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@Column(length = 4000)
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name ="type_id")
	private MonsterType monsterType;
	
	
	

	public MonsterRace() {
		super();
	}

	public MonsterRace(String name, String description, MonsterType monsterType) {
		super();
		this.name = name;
		this.description = description;
		this.monsterType = monsterType;
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
	
	public MonsterType getMonsterType() {
		return monsterType;
	}


	public void setMonsterType(MonsterType monsterType) {
		this.monsterType = monsterType;
	}

	
}
