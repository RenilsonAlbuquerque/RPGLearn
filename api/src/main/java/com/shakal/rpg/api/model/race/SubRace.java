package com.shakal.rpg.api.model.race;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.shakal.rpg.api.model.Race;


@Entity
@Table(name= "tb_sub_race")
public class SubRace {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@Column(length = 500)
	private String description;
	
	@OneToMany(mappedBy = "subRace",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY, targetEntity = SubRaceAtributeBonus.class)
	private List<SubRaceAtributeBonus> atributeBonus;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Race.class)
	@JoinColumn(name ="race_id", referencedColumnName = "id")
	private Race race;

	
	public SubRace() {
		super();
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}
	
	

}
