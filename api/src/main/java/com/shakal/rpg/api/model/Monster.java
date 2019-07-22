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



@Entity
@Table(name= "tb_monster")
@PrimaryKeyJoinColumn(name = "creature_id")
public class Monster extends Creature{

	
	private int armorClass;
	private int baseLifeDice;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name ="challenge_level_id")
	private MonsterChallengeLevel challengeLevel;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name ="size_id")
	private MonsterSize size;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name ="race_id")
	private MonsterRace race;

	@OneToMany(mappedBy = "monster",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<MonsterFeatures> features;
	
	
	


	public int getArmorClass() {
		return armorClass;
	}


	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}


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


	public List<MonsterFeatures> getFeatures() {
		return features;
	}


	public void setFeatures(List<MonsterFeatures> features) {
		this.features = features;
	}


	public MonsterChallengeLevel getChallengeLevel() {
		return challengeLevel;
	}


	public void setChallengeLevel(MonsterChallengeLevel challengeLevel) {
		this.challengeLevel = challengeLevel;
	}


	

	


	
	
	
}
