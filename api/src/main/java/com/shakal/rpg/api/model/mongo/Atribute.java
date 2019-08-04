package com.shakal.rpg.api.model.mongo;



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
	
	
	@Enumerated(EnumType.ORDINAL)
	private AtributeEnum value;
	
	public Atribute() {
		super();
	}

	public long getId() {
		return id;
	}

	

	public void setId(long id) {
		this.id = id;
	}
	

	public AtributeEnum getValue() {
		return value;
	}

	public void setValue(AtributeEnum value) {
		this.value = value;
	}
	

	

	
	
	

}
