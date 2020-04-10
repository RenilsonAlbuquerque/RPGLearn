package com.shakal.rpg.api.dto.info;

public class LevelDTO {
	
	private long id;
	private double value;
	private int xp;
	
	public LevelDTO(){
		
	}
	public LevelDTO(double value,int xp){
		this.value = value;
		this.xp =xp;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}

	
}
