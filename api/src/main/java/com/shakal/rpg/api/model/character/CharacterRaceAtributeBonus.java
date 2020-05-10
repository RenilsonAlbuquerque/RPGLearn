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

import com.shakal.rpg.api.model.Atribute;
import com.shakal.rpg.api.model.Race;


@Entity
@Table(name= "tb_character_race_atribute_bonus")
public class CharacterRaceAtributeBonus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Atribute.class)
	@JoinColumn(name ="atribute_id", referencedColumnName = "id")
	private Atribute atribute;
	
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

	

	public Atribute getAtribute() {
		return atribute;
	}

	public void setAtribute(Atribute atribute) {
		this.atribute = atribute;
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
