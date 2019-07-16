package com.shakal.rpg.api.model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.shakal.rpg.api.model.relation.CreatureAtribute;
import com.shakal.rpg.api.model.relation.CreatureResistence;


@Entity
@Table(name= "tb_monster")
@PrimaryKeyJoinColumn(name = "creature_id")
public class Monster extends Creature{

	
	private int baseLifeDice;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name ="race_id")
	private MonsterRace race;

	
	


	public int getBaseLifeDice() {
		return baseLifeDice;
	}


	public void setBaseLifeDice(int baseLifeDice) {
		this.baseLifeDice = baseLifeDice;
	}


	public MonsterRace getRace() {
		return race;
	}

	public void setRace(MonsterRace race) {
		this.race = race;
	}


	
	
	
}
