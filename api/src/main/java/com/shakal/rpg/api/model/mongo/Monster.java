package com.shakal.rpg.api.model.mongo;





import org.springframework.data.mongodb.core.mapping.Document;

import com.shakal.rpg.api.model.Atribute;



@Document(collection = "monster")
public class Monster extends Creature{

	
	private int armorClass;
	private int baseLifeDice;
	/*
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name ="challenge_level_id")
	private MonsterChallengeLevel challengeLevel;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name ="size_id")
	private MonsterSize size;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name ="race_id")
	private MonsterRace race;

	@OneToMany(mappedBy = "monster",cascade = CascadeType.ALL,fetch =  FetchType.EAGER, orphanRemoval = true)
	private Set<MonsterFeature> features;
	
	*/
	


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






	@Override
	public Atribute getForce() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Atribute getDexterity() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Atribute getConstitution() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Atribute getInteligence() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Atribute getWisdom() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Atribute getCharisma() {
		// TODO Auto-generated method stub
		return null;
	}


	

	


	
	
	
}
