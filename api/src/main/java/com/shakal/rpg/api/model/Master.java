package com.shakal.rpg.api.model;


import javax.persistence.Entity;
import javax.persistence.Table;




@Entity
@Table(name= "tb_master")
public class Master extends Role {

	/*
	@OneToMany(mappedBy = "master",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<MasterMonster> monsters;
	*/
}
