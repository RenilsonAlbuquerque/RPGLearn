package com.shakal.rpg.api.model.mongo;


import org.springframework.data.annotation.Id;



import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "action")
public class Action {

	@Id
	private long id;
	
	private String name;
	
	private String description;

	
	
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
	
	
	
}
