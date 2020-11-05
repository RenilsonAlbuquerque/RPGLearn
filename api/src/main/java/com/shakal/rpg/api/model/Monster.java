package com.shakal.rpg.api.model;




import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.shakal.rpg.api.model.creature.CreatureSize;



@Entity
@Table(name= "tb_monster")
@PrimaryKeyJoinColumn(name = "creature_id")
public class Monster extends Creature{

	
	private int armorClass;
	private int baseLifeDice;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name ="challenge_level_id")
	private CreatureLevel challengeLevel;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name ="size_id")
	private CreatureSize size;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name ="race_id")
	private MonsterRace race;

	@OneToMany(mappedBy = "monster",cascade = CascadeType.ALL,fetch =  FetchType.EAGER, orphanRemoval = true)
	private Set<MonsterFeature> features;
	
	@OneToMany(mappedBy = "creature",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Action> legendaryActions;
	


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


	


	public Set<MonsterFeature> getFeatures() {
		return features;
	}


	public void setFeatures(Set<MonsterFeature> features) {
		this.features = features;
	}


	public CreatureLevel getChallengeLevel() {
		return challengeLevel;
	}


	public void setChallengeLevel(CreatureLevel challengeLevel) {
		this.challengeLevel = challengeLevel;
	}


	public CreatureSize getSize() {
		return size;
	}


	public void setSize(CreatureSize size) {
		this.size = size;
	}


	public List<Action> getLegendaryActions() {
		return legendaryActions;
	}


	public void setLegendaryActions(List<Action> legendaryActions) {
		this.legendaryActions = legendaryActions;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.getId().intValue();
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Monster other = (Monster) obj;
		if (this.getId() != other.getId())
			return false;
		return true;
	}
	
	

	


	
	
	
}
