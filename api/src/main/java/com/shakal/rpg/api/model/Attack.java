package com.shakal.rpg.api.model;

import java.util.List;

import javax.persistence.*;

import com.shakal.rpg.api.model.relation.AttackDice;

@Entity
@Table(name= "tb_attack")
@PrimaryKeyJoinColumn(name = "action_id")
public class Attack extends Action{
	
	
	
	@OneToMany(mappedBy = "attack",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<AttackDice> damage;

	public List<AttackDice> getDamage() {
		return damage;
	}

	public void setDamage(List<AttackDice> damage) {
		this.damage = damage;
	}
	
	

}
