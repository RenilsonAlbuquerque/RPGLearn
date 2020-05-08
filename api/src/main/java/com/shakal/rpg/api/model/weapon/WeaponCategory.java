package com.shakal.rpg.api.model.weapon;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.shakal.rpg.api.model.equipament.EquipamentCategory;

@Entity
@Table(name= "tb_weapon_category")
@PrimaryKeyJoinColumn(name = "id")
public class WeaponCategory extends EquipamentCategory {

	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Weapon.class)
	private List<Weapon> weapon;

	public List<Weapon> getWeapon() {
		return weapon;
	}

	public void setWeapon(List<Weapon> weapon) {
		this.weapon = weapon;
	}
	
	
}
