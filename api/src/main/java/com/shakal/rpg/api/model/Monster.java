package com.shakal.rpg.api.model;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name= "tb_monster")
public class Monster extends Creature{

	
	
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name ="race_id")
	private MonsterRace race;

	
	
	public Monster() {
		super();
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MonsterRace getRace() {
		return race;
	}

	public void setRace(MonsterRace race) {
		this.race = race;
	}
	
	
	
	
}
