package com.shakal.rpg.api.model.mongo;




import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import com.shakal.rpg.api.model.enums.AtributeEnum;

@Document(collection = "atribute")
public class Atribute {
	
	
	@Id
	private String id;
	
	
	@Enumerated(EnumType.ORDINAL)
	private AtributeEnum value;
	
	public Atribute() {
		super();
	}

	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public AtributeEnum getValue() {
		return value;
	}

	public void setValue(AtributeEnum value) {
		this.value = value;
	}
	

	

	
	
	

}
