package com.shakal.rpg.api.model.relation;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.shakal.rpg.api.model.Character;
import com.shakal.rpg.api.model.Master;
import com.shakal.rpg.api.model.Monster;
import com.shakal.rpg.api.model.Weapon;
import com.shakal.rpg.api.model.embedded.CharacterWeaponId;
import com.shakal.rpg.api.model.embedded.MasterMonsterId;

@Entity
@Table(name= "mtm_master_monster")
public class MasterMonster {
	

	@EmbeddedId
	private MasterMonsterId id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@MapsId("monsterId")
	private Monster monster;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@MapsId("masterId")
	private Master master;

	public MasterMonsterId getId() {
		return id;
	}

	public void setId(MasterMonsterId id) {
		this.id = id;
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	public Master getMaster() {
		return master;
	}

	public void setMaster(Master master) {
		this.master = master;
	}
	

	
}
