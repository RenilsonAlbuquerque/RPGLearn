package com.shakal.rpg.api.dto.create;



public class DamageDiceDTO {
	private int quantity;
    private long dice;
    private long damageType;
    
    
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getDice() {
		return dice;
	}
	public void setDice(long dice) {
		this.dice = dice;
	}
	public long getDamageType() {
		return damageType;
	}
	public void setDamageType(long damageType) {
		this.damageType = damageType;
	}
	
    
    

}
