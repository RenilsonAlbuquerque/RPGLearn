package com.shakal.rpg.api.model.relation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.shakal.rpg.api.model.Character;
import com.shakal.rpg.api.model.Class;
import com.shakal.rpg.api.model.Level;

@Entity
@Table(name= "mtm_character_class")
public class CharacterClass {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private Character character;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private Class clasS;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private Level level;
	
}
