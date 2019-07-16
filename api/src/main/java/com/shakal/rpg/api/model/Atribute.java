package com.shakal.rpg.api.model;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.shakal.rpg.api.model.enums.AtributeEnum;

@Entity
@Table(name= "tb_atribute")
public class Atribute {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Embedded
	@Enumerated(EnumType.STRING)
	private AtributeEnum name;

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

	
	
	

}
