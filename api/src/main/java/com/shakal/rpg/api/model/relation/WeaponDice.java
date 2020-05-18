package com.shakal.rpg.api.model.relation;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.shakal.rpg.api.model.DamageType;
import com.shakal.rpg.api.model.Dice;
import com.shakal.rpg.api.model.embedded.WeaponDiceId;
import com.shakal.rpg.api.model.weapon.Weapon;

@Entity
@Table(name= "mtm_weapon_dice")
public class WeaponDice {
	
	
	@EmbeddedId
	private WeaponDiceId id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name ="weapon_id", referencedColumnName = "id")
	@MapsId("weaponId")
	private Weapon weapon;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@MapsId("diceId")
	private Dice dice;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@MapsId("damage_type_Id")
	private DamageType damageType;
	
	private int quantity;
	
	private int bonus;

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


	public int getBonus() {
		return bonus;
	}


	public void setBonus(int bonus) {
		this.bonus = bonus;
	}


	public DamageType getDamageType() {
		return damageType;
	}


	public void setDamageType(DamageType damageType) {
		this.damageType = damageType;
	}
	
	
	
	
	
	
	

}
