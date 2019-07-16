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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.shakal.rpg.api.model.enums.SexEnum;
import com.shakal.rpg.api.model.relation.CharacterRole;
import com.shakal.rpg.api.model.relation.CharacterWeapon;

@Entity
@Table(name= "tb_character")
@PrimaryKeyJoinColumn(name = "character_id")
public class Character {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	
	
	private SexEnum sexo;
	
	private int height;
	
	private int weight;
	
	private int age;
	
	private String background;
	
	@OneToMany(mappedBy = "character",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CharacterClass> classes;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_id")
	private Race race;
	
	@OneToMany(mappedBy = "character",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CharacterWeapon> weapons;
	
	
	@OneToMany(mappedBy = "character",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CharacterRole> character;

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

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public SexEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexEnum sexo) {
		this.sexo = sexo;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<CharacterClass> getClasses() {
		return classes;
	}

	public void setClasses(List<CharacterClass> classes) {
		this.classes = classes;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public List<CharacterWeapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<CharacterWeapon> weapons) {
		this.weapons = weapons;
	}

	public List<CharacterRole> getCharacter() {
		return character;
	}

	public void setCharacter(List<CharacterRole> character) {
		this.character = character;
	}
	
	
	
	
	
	
}
