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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "mtm_sub_race_trait",
            joinColumns = @JoinColumn(name = "sub_race_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "trait_id", referencedColumnName = "id"))
    private List<Trait> traits;
	
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

	public List<SubRaceAtributeBonus> getAtributeBonus() {
		return atributeBonus;
	}

	public void setAtributeBonus(List<SubRaceAtributeBonus> atributeBonus) {
		this.atributeBonus = atributeBonus;
	}

	public List<Trait> getTraits() {
		return traits;
	}

	public void setTraits(List<Trait> traits) {
		this.traits = traits;
	}
	
	

}
