package com.shakal.rpg.api.dto.info;

public class AtributeInfoDTO {
	
	private long id;
	private int value;
	private int modfier;
	private boolean proeficiency;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getModfier() {
		return modfier;
	}
	public void setModfier(int modfier) {
		this.modfier = modfier;
	}
	public boolean isProeficiency() {
		return proeficiency;
	}
	public void setProeficiency(boolean proeficiency) {
		this.proeficiency = proeficiency;
	}
	
	

}
