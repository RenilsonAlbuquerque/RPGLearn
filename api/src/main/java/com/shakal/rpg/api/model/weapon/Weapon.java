package com.shakal.rpg.api.model.weapon;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.shakal.rpg.api.contracts.entity.IWereable;
import com.shakal.rpg.api.model.economy.Cost;
import com.shakal.rpg.api.model.equipament.Rarity;
import com.shakal.rpg.api.model.relation.WeaponDice;

@Entity
@Table(name="tb_weapon")
public class Weapon implements IWereable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String imagePath;
	
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
	@MapsId("classification_Id")
	private WeaponClassification classification;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = WeaponRange.class )
	@MapsId("range_Id")
	private WeaponRange range;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="cost_id")
	private Cost price;
	
	private int weight;
	
	@OneToMany(mappedBy = "weapon",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<WeaponDice> damage;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("rarity_Id")
	private Rarity rarity;

	public Weapon() {
		super();
	}

	

	public Weapon(String name, double price, int weight) {
		super();
		this.name = name;
		this.weight = weight;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

	public String getImagePath() {
		return imagePath;
	}



	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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



	public Cost getPrice() {
		return price;
	}



	public void setPrice(Cost price) {
		this.price = price;
	}



	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	

	public List<WeaponDice> getDamage() {
		return damage;
	}



	public void setDamage(List<WeaponDice> damage) {
		this.damage = damage;
	}



	public Rarity getRarity() {
		return rarity;
	}



	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}



	@Override
	public Cost price() {
		// TODO Auto-generated method stub
		return this.price;
	}



	@Override
	public int weight() {
		// TODO Auto-generated method stub
		return this.weight;
	}



	



	
	
	
}
