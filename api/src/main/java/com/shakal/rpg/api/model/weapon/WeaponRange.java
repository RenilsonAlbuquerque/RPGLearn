package com.shakal.rpg.api.model.weapon;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_weapon_range")
public class WeaponRange {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@OneToMany(mappedBy = "range",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Weapon> weapon;

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

	public List<Weapon> getWeapon() {
		return weapon;
	}

	public void setWeapon(List<Weapon> weapon) {
		this.weapon = weapon;
	}
	
	

}
