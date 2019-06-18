package com.shakal.rpg.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.shakal.rpg.api.contracts.IWereable;
import com.shakal.rpg.api.model.enums.WeaponClassificationEnum;

@Entity
@Table(name= "tb_weapon")
public class Weapon implements IWereable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@Enumerated(EnumType.ORDINAL)
	private WeaponClassificationEnum type;
	
	private double price;
	
	private int weight;
	
	@OneToMany(mappedBy = "weapon",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private WeaponDice damage;
	


	public Weapon() {
		super();
	}

	

	public Weapon(String name, WeaponClassificationEnum type, double price, int weight) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.weight = weight;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WeaponClassificationEnum getType() {
		return type;
	}

	public void setType(WeaponClassificationEnum type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	

	public WeaponDice getDamage() {
		return damage;
	}



	public void setDamage(WeaponDice damage) {
		this.damage = damage;
	}



	@Override
	public double price() {
		return this.price;
	}

	@Override
	public int weight() {
		return this.weight;
	}
	
	
}
