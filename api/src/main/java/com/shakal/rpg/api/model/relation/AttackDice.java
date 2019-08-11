package com.shakal.rpg.api.model.relation;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.shakal.rpg.api.model.Attack;
import com.shakal.rpg.api.model.DamageType;
import com.shakal.rpg.api.model.Dice;
import com.shakal.rpg.api.model.embedded.AttackDiceId;

@Entity
@Table(name= "mtm_attack_dice")
public class AttackDice {
	
	@EmbeddedId
	private AttackDiceId id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "attack_id",referencedColumnName = "action_id")
	@MapsId("attackId")
	private Attack attack;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
	@MapsId("diceId")
	private Dice dice;
	
	private int quantity;
	
	private int bonusDamage;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name = "damage_type_id")
	private DamageType damageType;
	
	

	public AttackDice() {
		super();
	}

	public AttackDice( Attack attack, Dice dice, int quantity) {
		super();
		this.attack = attack;
		this.dice = dice;
		this.quantity = quantity;
	}

	public AttackDiceId getId() {
		return id;
	}

	public void setId(AttackDiceId id) {
		this.id = id;
	}

	public Attack getAttack() {
		return attack;
	}

	public void setAttack(Attack attack) {
		this.attack = attack;
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

	public int getBonusDamage() {
		return bonusDamage;
	}

	public void setBonusDamage(int bonusDamage) {
		this.bonusDamage = bonusDamage;
	}

	public DamageType getDamageType() {
		return damageType;
	}

	public void setDamageType(DamageType damageType) {
		this.damageType = damageType;
	}
	
	
	
}
