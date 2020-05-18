package com.shakal.rpg.api.model.adventuregear;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.shakal.rpg.api.model.equipament.Equipament;

@Entity
@Table(name="tb_adventure_gear")
@PrimaryKeyJoinColumn(name = "id")
public class AdventureGear extends Equipament {
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = AdventureGearCategory.class)
	@JoinColumn(name ="category_id", referencedColumnName = "id")
	private AdventureGearCategory category;

	public AdventureGearCategory getCategory() {
		return category;
	}

	public void setCategory(AdventureGearCategory category) {
		this.category = category;
	}
	
	

}
