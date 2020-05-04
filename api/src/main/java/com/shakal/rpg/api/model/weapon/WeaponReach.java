package com.shakal.rpg.api.model.weapon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_weapon_reach")
public class WeaponReach {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private int normalDistance;
	
	private int maximumDistance;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNormalDistance() {
		return normalDistance;
	}

	public void setNormalDistance(int normalDistance) {
		this.normalDistance = normalDistance;
	}

	public int getMaximumDistance() {
		return maximumDistance;
	}

	public void setMaximumDistance(int maximumDistance) {
		this.maximumDistance = maximumDistance;
	}
	
	
}
