package com.shakal.rpg.api.model;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;




@Entity
@Table(name= "tb_master")
@PrimaryKeyJoinColumn(name = "role_id")
public class Master extends Role {

	/*
	@OneToMany(mappedBy = "master",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<MasterMonster> monsters;
	*/
}
