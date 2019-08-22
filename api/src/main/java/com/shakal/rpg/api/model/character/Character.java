package com.shakal.rpg.api.model.character;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.shakal.rpg.api.model.Creature;
import com.shakal.rpg.api.model.enums.SexEnum;
import com.shakal.rpg.api.model.relation.UserStory;

@Entity
@Table(name= "tb_character")
@PrimaryKeyJoinColumn(name = "creature_id")
public class Character extends Creature{
	
	private String name;
	
	private int age;
	
	@Enumerated(EnumType.STRING)
	private SexEnum sex;
	
	private int height;
	
	private int weight;
	
	@Column(length = 5000)
	private String backgroundStory;
	
	private int armorClass;
	
	
	@OneToMany(mappedBy = "character",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<UserStory> userStory;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public SexEnum getSex() {
		return sex;
	}

	public void setSex(SexEnum sex) {
		this.sex = sex;
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

	public String getBackgroundStory() {
		return backgroundStory;
	}

	public void setBackgroundStory(String backgroundStory) {
		this.backgroundStory = backgroundStory;
	}

	public int getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}

	public List<UserStory> getUserStory() {
		return userStory;
	}

	public void setUserStory(List<UserStory> userStory) {
		this.userStory = userStory;
	}
	
	
	

}
