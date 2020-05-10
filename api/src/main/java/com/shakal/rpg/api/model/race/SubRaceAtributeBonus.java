package com.shakal.rpg.api.model.race;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.shakal.rpg.api.model.Atribute;



@Entity
@Table(name= "tb_character_subrace_atribute_bonus")
public class SubRaceAtributeBonus {

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Atribute.class)
	@JoinColumn(name ="atribute_id", referencedColumnName = "id")
	private Atribute atribute;
	
	private int bonus;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = SubRace.class)
	@JoinColumn(name ="sub_race_id", referencedColumnName = "id")
	private SubRace subRace;

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

	public SubRace getSubRace() {
		return subRace;
	}

	public void setSubRace(SubRace subRace) {
		this.subRace = subRace;
	}
	
	
	
}
