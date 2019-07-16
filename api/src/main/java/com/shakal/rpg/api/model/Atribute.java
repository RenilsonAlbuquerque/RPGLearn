package com.shakal.rpg.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.shakal.rpg.api.model.enums.AtributeEnum;

@Entity
@Table(name= "tb_atribute")
public class Atribute {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Enumerated(EnumType.STRING)
	private AtributeEnum name;
	
	private int value;
	
	private int bonus;
	
	private boolean proeficiency;
	
	/*
	@OneToOne
	@JoinColumn(name ="creature_id")
	private Creature creature;
*/
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AtributeEnum getName() {
		return name;
	}

	public void setName(AtributeEnum name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public boolean isProeficiency() {
		return proeficiency;
	}

	public void setProeficiency(boolean proeficiency) {
		this.proeficiency = proeficiency;
	}

	
	

}
