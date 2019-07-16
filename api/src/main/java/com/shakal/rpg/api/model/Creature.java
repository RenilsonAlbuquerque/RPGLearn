package com.shakal.rpg.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.shakal.rpg.api.contracts.ICreature;

@Entity
@Table(name= "tb_creature")
@Inheritance( strategy = InheritanceType.JOINED)
public class Creature implements ICreature{

	@Id
	@GeneratedValue
	private long id;

	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
