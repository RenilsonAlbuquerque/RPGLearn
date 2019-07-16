package com.shakal.rpg.api.model;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.shakal.rpg.api.model.embedded.WeaponDiceId;
import com.shakal.rpg.api.model.enums.DiceEnum;

@Entity
@Table(name= "mtm_weapon_dice")
public class WeaponDice {
	
	
	@EmbeddedId
	private WeaponDiceId id;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@MapsId("weaponId")
	private Weapon weapon;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@MapsId("diceId")
	private Dice dice;
	
	
	private int quantity;
	
	
	
	


	public WeaponDice() {
		super();
	}


	public WeaponDice(Weapon weapon, Dice dice, int quantity) {
		super();
		this.weapon = weapon;
		this.dice = dice;
		this.quantity = quantity;
	}



	


	public WeaponDiceId getId() {
		return id;
	}


	public void setId(WeaponDiceId id) {
		this.id = id;
	}


	public Weapon getWeapon() {
		return weapon;
	}


	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}


	public Dice getDice() {
		return dice;
	}


	public void setDice(Dice dice) {
		this.dice = dice;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
	
	

}
