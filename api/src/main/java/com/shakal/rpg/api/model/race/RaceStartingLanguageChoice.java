package com.shakal.rpg.api.model.race;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.shakal.rpg.api.model.Language;
import com.shakal.rpg.api.model.Race;

@Entity
@Table(name= "tb_race_starting_language_choice")
public class RaceStartingLanguageChoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private int choose;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "mtm_race_starting_language_choice",
            joinColumns = @JoinColumn(name = "race_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "language_id", referencedColumnName = "id"))
    private List<Language> langauges;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Race race;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getChoose() {
		return choose;
	}

	public void setChoose(int choose) {
		this.choose = choose;
	}

	public List<Language> getLangauges() {
		return langauges;
	}

	public void setLangauges(List<Language> langauges) {
		this.langauges = langauges;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}
	
	
	
}
