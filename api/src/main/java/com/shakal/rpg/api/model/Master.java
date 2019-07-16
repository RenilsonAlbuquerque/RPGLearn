package com.shakal.rpg.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.shakal.rpg.api.model.relation.MasterMonster;

@Entity
@Table(name= "tb_master")
public class Master extends Role {

	/*
	@OneToMany(mappedBy = "master",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<MasterMonster> monsters;
	*/
}
