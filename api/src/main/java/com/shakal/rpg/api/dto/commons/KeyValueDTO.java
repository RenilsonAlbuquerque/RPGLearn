package com.shakal.rpg.api.dto.commons;

public class KeyValueDTO {

	private long id;
	private String value;
	
	public KeyValueDTO() {
		
	}
	public KeyValueDTO(long id, String value) {
		this.setId(id);
		this.setValue(value);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
