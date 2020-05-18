package com.shakal.rpg.api.model.character;


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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.shakal.rpg.api.model.Atribute;
import com.shakal.rpg.api.model.Dice;
import com.shakal.rpg.api.model.creature.Proeficiency;


@Entity
@Table(name= "tb_class")
public class Class {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="life_dice_id")
	private Dice lifeDice;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "mtm_class_proeficiency",
            joinColumns = @JoinColumn(name = "class_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "proeficiency_id", referencedColumnName = "id"))
    private List<Proeficiency> proeficiencies;
	
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.REMOVE, mappedBy= "clasS")
	@JoinColumn(name ="starting_proeficiency_id",referencedColumnName = "id")
	private ClassStartingProeficiencyChoice startingProficiencyOptions;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "mtm_class_atribute",
            joinColumns = @JoinColumn(name = "class_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "atribute_id", referencedColumnName = "id"))
    private List<Atribute> savingThrows;
	

	
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

	public Dice getLifeDice() {
		return lifeDice;
	}

	public void setLifeDice(Dice lifeDice) {
		this.lifeDice = lifeDice;
	}

	public ClassStartingProeficiencyChoice getStartingProficiencyOptions() {
		return startingProficiencyOptions;
	}

	public void setStartingProficiencyOptions(ClassStartingProeficiencyChoice startingProficiencyOptions) {
		this.startingProficiencyOptions = startingProficiencyOptions;
	}

	public List<Proeficiency> getProeficiencies() {
		return proeficiencies;
	}

	public void setProeficiencies(List<Proeficiency> proeficiencies) {
		this.proeficiencies = proeficiencies;
	}

	public List<Atribute> getSavingThrows() {
		return savingThrows;
	}

	public void setSavingThrows(List<Atribute> savingThrows) {
		this.savingThrows = savingThrows;
	}

	
	


}
