package com.shakal.rpg.api.model;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.shakal.rpg.api.model.character.CharacterRaceAtributeBonus;
import com.shakal.rpg.api.model.creature.CreatureSize;
import com.shakal.rpg.api.model.equipament.EquipamentCategory;
import com.shakal.rpg.api.model.race.RaceStartingLanguageChoice;
import com.shakal.rpg.api.model.race.RaceStartingProeficiencyChoice;
import com.shakal.rpg.api.model.race.SubRace;
import com.shakal.rpg.api.model.race.Trait;

@Entity
@Table(name= "tb_race")
public class Race {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@Column(length = 500)
	private String description;
	
	private int speed;
	
	@Column(length = 500)
	private String alignmentDescription;
	
	@OneToMany(mappedBy = "race",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY, targetEntity = SubRace.class)
	private List<SubRace> subRaces;
	
	@OneToMany(mappedBy = "race",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY, targetEntity = CharacterRaceAtributeBonus.class)
	private List<CharacterRaceAtributeBonus> atributeBonus;
	
	
	
	@Column(length = 700)
	private String ageDescription;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name ="size_id")
	private CreatureSize size;
	
	@Column(length = 700)
	private String sizeDescription;
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "mtm_race__equipment_category",
            joinColumns = @JoinColumn(name = "race_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "equipment_category_id", referencedColumnName = "id"))
    private List<EquipamentCategory> equipmentProeficiency;
	
	
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.REMOVE, mappedBy= "race")
	@JoinColumn(name ="starting_proeficiency_id",referencedColumnName = "id")
	private RaceStartingProeficiencyChoice startingProficiencyOptions;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "mtm_race_language",
            joinColumns = @JoinColumn(name = "race_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "language_id", referencedColumnName = "id"))
    private List<Language> langauges;
	
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.REMOVE, mappedBy= "race")
	@JoinColumn(name ="starting_langauge_id",referencedColumnName = "id")
	private RaceStartingLanguageChoice startingLanguageOptions;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "mtm_race_trait",
            joinColumns = @JoinColumn(name = "race_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "trait_id", referencedColumnName = "id"))
    private List<Trait> traits;
	
	@Column(length = 700)
	private String languageDescription;
	
	public Race() {
		
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


	public List<SubRace> getSubRaces() {
		return subRaces;
	}


	public void setSubRaces(List<SubRace> subRaces) {
		this.subRaces = subRaces;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public List<CharacterRaceAtributeBonus> getAtributeBonus() {
		return atributeBonus;
	}


	public void setAtributeBonus(List<CharacterRaceAtributeBonus> atributeBonus) {
		this.atributeBonus = atributeBonus;
	}


	public String getAlignmentDescription() {
		return alignmentDescription;
	}


	public void setAlignmentDescription(String alignmentDescription) {
		this.alignmentDescription = alignmentDescription;
	}


	

	public String getAgeDescription() {
		return ageDescription;
	}


	public void setAgeDescription(String ageDescription) {
		this.ageDescription = ageDescription;
	}


	public CreatureSize getSize() {
		return size;
	}


	public void setSize(CreatureSize size) {
		this.size = size;
	}


	public String getSizeDescription() {
		return sizeDescription;
	}


	public void setSizeDescription(String sizeDescription) {
		this.sizeDescription = sizeDescription;
	}


	public List<EquipamentCategory> getEquipmentProeficiency() {
		return equipmentProeficiency;
	}


	public void setEquipmentProeficiency(List<EquipamentCategory> equipmentProeficiency) {
		this.equipmentProeficiency = equipmentProeficiency;
	}


	public RaceStartingProeficiencyChoice getStartingProficiencyOptions() {
		return startingProficiencyOptions;
	}


	public void setStartingProficiencyOptions(RaceStartingProeficiencyChoice startingProficiencyOptions) {
		this.startingProficiencyOptions = startingProficiencyOptions;
	}


	public List<Language> getLangauges() {
		return langauges;
	}


	public void setLangauges(List<Language> langauges) {
		this.langauges = langauges;
	}


	public RaceStartingLanguageChoice getStartingLanguageOptions() {
		return startingLanguageOptions;
	}


	public void setStartingLanguageOptions(RaceStartingLanguageChoice startingLanguageOptions) {
		this.startingLanguageOptions = startingLanguageOptions;
	}


	public String getLanguageDescription() {
		return languageDescription;
	}


	public void setLanguageDescription(String languageDescription) {
		this.languageDescription = languageDescription;
	}


	


	
	
	
	
}
