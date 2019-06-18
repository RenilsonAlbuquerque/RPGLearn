package com.shakal.rpg.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "tb_level")
public class Level {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private int value;
	
	
}
