package com.shakal.rpg.api.model;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.shakal.rpg.api.model.enums.DiceEnum;

@Entity
@Table(name= "tb_dice")
public class Dice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@Enumerated(EnumType.ORDINAL)
	private DiceEnum value;
	
	
	public Dice() {
		
	}

	public Dice(long id, DiceEnum value) {
		super();
		this.id = id;
		this.value = value;
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DiceEnum getValue() {
		return value;
	}

	public void setValue(DiceEnum value) {
		this.value = value;
	}
	

	
	
}
