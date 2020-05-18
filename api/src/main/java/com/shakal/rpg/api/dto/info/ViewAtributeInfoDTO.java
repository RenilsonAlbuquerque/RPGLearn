package com.shakal.rpg.api.dto.info;

public class ViewAtributeInfoDTO {
	private boolean marked;
	private int bonus;
	private String label;
	
	public ViewAtributeInfoDTO() {
		
	}
	
	
	public ViewAtributeInfoDTO(boolean marked, int bonus, String label) {
		super();
		this.marked = marked;
		this.bonus = bonus;
		this.label = label;
	}


	public boolean isMarked() {
		return marked;
	}
	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	

}
