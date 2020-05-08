package com.shakal.rpg.api.model.adventuregear;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.shakal.rpg.api.model.equipament.EquipamentCategory;

@Entity
@Table(name= "tb_adventure_gear_category")
@PrimaryKeyJoinColumn(name = "id")
public class AdventureGearCategory extends EquipamentCategory {
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = AdventureGear.class)
	private List<AdventureGear> adventureGear;

	public List<AdventureGear> getAdventureGear() {
		return adventureGear;
	}

	public void setAdventureGear(List<AdventureGear> adventureGear) {
		this.adventureGear = adventureGear;
	}

	
}
