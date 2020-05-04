package com.shakal.rpg.api.model.character;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.shakal.rpg.api.model.Race;


@Entity
@Table(name= "tb_character_class_atribute_bonus")
public class CharacterRaceAtributeBonus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private int ability;
	
	private int bonus;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Race.class)
	@JoinColumn(name ="race_id", referencedColumnName = "id")
	private Race race;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAbility() {
		return ability;
	}

	public void setAbility(int ability) {
		this.ability = ability;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}
	
	
	
	
}
