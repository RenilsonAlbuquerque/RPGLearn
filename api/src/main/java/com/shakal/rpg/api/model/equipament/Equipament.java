package com.shakal.rpg.api.model.equipament;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.shakal.rpg.api.contracts.entity.IEquipament;
import com.shakal.rpg.api.model.economy.Cost;

@Entity
@Table(name= "tb_equipament")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Equipament implements IEquipament{

	@Id
	@GeneratedValue
	private Long id;
	
	private String imagePath;
	
	private String name;
	
	@Column(length = 1000)
	private String description;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="cost_id")
	private Cost price;
	
	private double weight;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("rarity_Id")
	private Rarity rarity;
	
	@OneToMany(mappedBy = "equipament",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<EquipmentRequirement> requirements;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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



	public Cost getPrice() {
		return price;
	}



	public void setPrice(Cost price) {
		this.price = price;
	}

	

	



	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Rarity getRarity() {
		return rarity;
	}



	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}


	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}

	
	

	public List<EquipmentRequirement> getRequirements() {
		return requirements;
	}



	public void setRequirements(List<EquipmentRequirement> requirements) {
		this.requirements = requirements;
	}



	@Override
	public Cost price() {
		// TODO Auto-generated method stub
		return this.price;
	}



	@Override
	public double weight() {
		// TODO Auto-generated method stub
		return this.weight;
	}
}
