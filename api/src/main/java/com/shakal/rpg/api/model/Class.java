package com.shakal.rpg.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.shakal.rpg.api.model.enums.DiceEnum;

@Entity
@Table(name= "tb_class")
public class Class {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private String description;
	
	private DiceEnum lifedice;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DiceEnum getLifedice() {
		return lifedice;
	}

	public void setLifedice(DiceEnum lifedice) {
		this.lifedice = lifedice;
	}
	
	


}
