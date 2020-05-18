package com.shakal.rpg.api.model.weapon;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.shakal.rpg.api.model.equipament.Equipament;
import com.shakal.rpg.api.model.relation.WeaponDice;

@Entity
@Table(name="tb_weapon")
@PrimaryKeyJoinColumn(name = "id")
public class Weapon extends Equipament {

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = WeaponCategory.class)
	@JoinColumn(name ="category_id", referencedColumnName = "id")
	private WeaponCategory category;
	

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = WeaponClassification.class )
	@JoinColumn(name ="classification_id", referencedColumnName = "id")
	private WeaponClassification classification;

	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = WeaponRange.class )
	@MapsId("range_Id")
	private WeaponRange range;
	
	
	
	@OneToMany(mappedBy = "weapon",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<WeaponDice> damage;
	
	private int bonus;

	public Weapon() {
		super();
	}

	

	public Weapon(String name, double price, int weight) {
		super();
		this.setName(name);
		this.setWeight(weight);
	}

	public WeaponClassification getClassification() {
		return classification;
	}



	public void setClassification(WeaponClassification classification) {
		this.classification = classification;
	}



	public WeaponRange getRange() {
		return range;
	}



	public void setRange(WeaponRange range) {
		this.range = range;
	}



	public WeaponCategory getCategory() {
		return category;
	}



	public void setCategory(WeaponCategory category) {
		this.category = category;
	}



	public List<WeaponDice> getDamage() {
		return damage;
	}



	public void setDamage(List<WeaponDice> damage) {
		this.damage = damage;
	}



	public int getBonus() {
		return bonus;
	}



	public void setBonus(int bonus) {
		this.bonus = bonus;
	}





}
