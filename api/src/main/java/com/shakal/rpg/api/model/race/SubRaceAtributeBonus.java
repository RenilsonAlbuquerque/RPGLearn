package com.shakal.rpg.api.model.race;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name= "tb_character_subrace_atribute_bonus")
public class SubRaceAtributeBonus {

	@Id
	@GeneratedValue
	private long id;
	
	private int ability;
	
	private int bonus;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = SubRace.class)
	@JoinColumn(name ="race_id", referencedColumnName = "id")
	private SubRace subRace;

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

	public SubRace getSubRace() {
		return subRace;
	}

	public void setSubRace(SubRace subRace) {
		this.subRace = subRace;
	}
	
	
	
}
