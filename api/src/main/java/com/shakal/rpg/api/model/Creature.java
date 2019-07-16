package com.shakal.rpg.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.shakal.rpg.api.contracts.ICreature;
import com.shakal.rpg.api.model.enums.AtributeEnum;
import com.shakal.rpg.api.model.relation.CreatureAtribute;
import com.shakal.rpg.api.model.relation.CreatureResistence;

@Entity
@Table(name= "tb_creature")
@Inheritance( strategy = InheritanceType.JOINED)
public abstract class Creature implements ICreature{

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "creature",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CreatureAtribute> atributes;
	
	@OneToMany(mappedBy = "creature",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CreatureResistence> resistences;
	
	
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public List<CreatureResistence> getResistences() {
		return resistences;
	}

	public void setResistences(List<CreatureResistence> resistences) {
		this.resistences = resistences;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAtributes(List<CreatureAtribute> atributes) {
		this.atributes = atributes;
	}

	@Override
	public Atribute getForce() {
		Atribute result = null;
		for(CreatureAtribute a: this.atributes) {
			if(a.getAtribute().getName() == AtributeEnum.FORCE) {
				result = a.getAtribute();
			}
		}
		return result;
	}

	@Override
	public Atribute getDexterity() {
		Atribute result = null;
		for(CreatureAtribute a: this.atributes) {
			if(a.getAtribute().getName() == AtributeEnum.DEXTERITY) {
				result = a.getAtribute();
			}
		}
		return result;
	}

	@Override
	public Atribute getConstitution() {
		Atribute result = null;
		for(CreatureAtribute a: this.atributes) {
			if(a.getAtribute().getName() == AtributeEnum.CONSTITUTION) {
				result = a.getAtribute();
			}
		}
		return result;
	}

	@Override
	public Atribute getInteligence() {
		Atribute result = null;
		for(CreatureAtribute a: this.atributes) {
			if(a.getAtribute().getName() == AtributeEnum.INTELIGENCE) {
				result = a.getAtribute();
			}
		}
		return result;
	}

	@Override
	public Atribute getWisdom() {
		Atribute result = null;
		for(CreatureAtribute a: this.atributes) {
			if(a.getAtribute().getName() == AtributeEnum.WISDOM) {
				result = a.getAtribute();
			}
		}
		return result;
	}

	@Override
	public Atribute getCharisma() {
		Atribute result = null;
		for(CreatureAtribute a: this.atributes) {
			if(a.getAtribute().getName() == AtributeEnum.CHARISMA) {
				result = a.getAtribute();
			}
		}
		return result;
	}
	
	 
}
