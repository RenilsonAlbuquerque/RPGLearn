package com.shakal.rpg.api.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name= "tb_player")
@PrimaryKeyJoinColumn(name = "role_id")
public class Player extends Role {
	
	
	
	
	

}
