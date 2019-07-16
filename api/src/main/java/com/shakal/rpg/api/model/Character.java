package com.shakal.rpg.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.shakal.rpg.api.model.enums.SexEnum;
import com.shakal.rpg.api.model.relation.CharacterWeapon;

@Entity
@Table(name= "tb_character")
public class Character {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private String background;
	
	private SexEnum sexo;
	
	private int height;
	
	private int weight;
	
	private int age;
	
	@OneToMany(mappedBy = "character",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CharacterClass> classes;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_id")
	private Race race;
	
	@OneToMany(mappedBy = "character",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CharacterWeapon> weapons;
	
	
	
	
	
	
	
	
}
