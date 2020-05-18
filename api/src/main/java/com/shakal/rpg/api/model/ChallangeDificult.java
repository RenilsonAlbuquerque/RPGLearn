package com.shakal.rpg.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "tb_challange_dificult")
public class ChallangeDificult {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private int level;
	
	private int easy;
	
	private int medium;
	
	private int hard;
	
	private int deadly;

	public ChallangeDificult() {
		
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getEasy() {
		return easy;
	}

	public void setEasy(int easy) {
		this.easy = easy;
	}

	public int getMedium() {
		return medium;
	}

	public void setMedium(int medium) {
		this.medium = medium;
	}

	public int getHard() {
		return hard;
	}

	public void setHard(int hard) {
		this.hard = hard;
	}

	public int getDeadly() {
		return deadly;
	}

	public void setDeadly(int deadly) {
		this.deadly = deadly;
	}
	
	
	
}
