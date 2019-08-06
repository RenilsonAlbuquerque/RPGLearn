package com.shakal.rpg.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "tb_action")
@Inheritance( strategy = InheritanceType.JOINED)
public class Action {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@Column(length = 4000)
	private String description;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST )
	@JoinColumn(name ="creature_id", referencedColumnName ="id")
	private Creature creature;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST )
	@JoinColumn(name ="legendary_action_monster_id", referencedColumnName ="creature_id")
	private Monster monster;
	
	
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

	public Creature getCreature() {
		return creature;
	}

	public void setCreature(Creature creature) {
		this.creature = creature;
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}
	
	
	
}
